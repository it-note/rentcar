const id = $('#id');
const password = $('#password');
const password2 = $('#password2');
const name = $('#name');
const phone = $('#phone');
const zonecode = $('#zonecode');
const address = $('#address');
const subaddress = $('#subaddress');

let checkDupl = false;
let checkDuplContact = false;

$(window).keypress(e => {
	if(e.keyCode === 13) {
		checkValues($('form')[0]);
	}
});

id.on("change", e => {
	checkDuplId();
});

phone.on("change", e => {
	checkPhoneForm();
});

function checkDuplId() {
	const str = trimText(id.val());

	const reg = /\W/;
	const check = str.match(reg);

	$.ajax({
		"url": `http://localhost:8081/service?command=checkduplid&id=${str}`,
		"method": "POST",
		"timeout": 0,
	}).done(function(response) {
		const message = $('#msg');

		if (check !== null) {
			message.text("A~Z a~z 0~9 _ 조합으로 작성 가능합니다.");
			message.css('color', 'red');
			checkDupl = false;
		} else if (response.result === true) {
			message.text("중복되는 아이디입니다.");
			message.css('color', 'red');
			checkDupl = false;
		} else if (str.length < 6) {
			message.text("아이디는 6자리 이상이여야합니다.");
			message.css('color', 'red');
			checkDupl = false;
		} else {
			message.text('아주 좋은 아이디입니다.');
			message.css('color', '#4491ca');
			checkDupl = true;
		}
		id.val(str);
	});
}

function checkPhoneForm() {
	let str = trimText(phone.val());

	if (str.length === 11) {
		const exp = /\d{11}/;
		const check = str.match(exp);

		if (check !== null) {
			const agency = str.substr(0, 3);
			const area = str.substr(4, 4);
			const number = str.substr(9);

			str = `${agency}-${area}-${number}`;
		}
	}

	const reg = /\d{3}-\d{4}-\d{4}/;
	const result = str.match(reg);
	const message = $('#msg-phone');

	phone.val(str);

	if (str.length === 13 && result !== null) {

		if (checkDuplPhone() === false) {
			message.text('');
			checkDuplContact = true;
			return true;
		}
		else {
			message.text('중복되는 연락처입니다.')
			message.css('color', 'red');
			checkDuplContact = false;
			return false;;
		}
	} else {
		message.text('###-####-####');
		message.css('color', 'red');
		return false;;
	}
}

function checkDuplPhone() {
	const str = trimText(password.val());
	
	let result = true;
	$.ajax({
		"url": `http://localhost:8081/service?command=checkduplphone&phone=${phone.val()}`,
		"method": "GET",
		"timeout": 0,
		"async" : false,
	}).done(function(response) {
		result = response.result;
	});
	return result;
}

function trimText(text) {
	let str = text.trim();

	let result = '';
	for (let i = 0; i < str.length; i++) {
		if (str.charAt(i) !== ' ') {
			result += str.charAt(i);
		}
	}

	return result;
}

function searchZonecode() {
	new daum.Postcode({
		oncomplete: function(data) {
			address.val(data.address);
			zonecode.val(data.zonecode);
		}
	}).open();
}

function checkValues(form) {
	let check = true;
	let url = "join?";

	if (id.val() !== "") {
		url += "&id=" + id.val();
	} else {
		if (check === true) alert("아이디를 입력하지 않았습니다.")
		check = false;
	}

	if (password.val() === "") {
		if (check === true) alert("비밀번호를 입력하지 않았습니다.")
		check = false;
	}

	if (password2.val() === "" || password.val() !== password2.val()) {
		if (check === true) alert("검증 비밀번호가 일치하지 않습니다.")
		check = false;
	}

	if (name.val() !== "") {
		url += "&name=" + trimText(name.val());
	} else {
		if (check === true) alert("이름을 입력하지 않았습니다.")
		check = false;
	}

	if (phone.val() !== "") {
		url += "&phone=" + phone.val();
	} else {
		if (check === true) alert("연락처를 입력하지 않았습니다.")
		check = false;
	}

	if (zonecode.value !== "") {
		url += "&zonecode=" + zonecode.val();
		url += "&address=" + address.val();
		url += "&subaddress=" + subaddress.val();
	}

	if (check === false) {
		location.href = url;
	} else if (checkDupl === false) {
		alert("아이디 중복확인을 해주세요.");
	} else if (checkDuplContact === false) {
		alert("중복된 연락처입니다.");
	} else {
		alert("회원가입 성공");
		const secret = key();
		$('#key').val(secret);
		password.val(encryptData(password.val(), secret));
		form.submit();
	}
}

function key() {
	let result = "";

	$.ajax({
		"url": "http://localhost:8081/service?command=generatekey",
		"method": "GET",
		"async": false
	}).done(function(response) {
		result = response.key;
	});

	return result;
}

function encryptData(data, secret) {
	const iv = CryptoJS.enc.Base64.parse("");
	const key = CryptoJS.SHA256(secret);

	encryptedString = CryptoJS.AES.encrypt(data, key, {
		iv: iv,
		mode: CryptoJS.mode.CBC,
		padding: CryptoJS.pad.Pkcs7
	});

	return encryptedString.toString();
}