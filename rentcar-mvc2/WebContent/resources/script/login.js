const path = window.location.search.substr(1);
const params = path.split('&');

if(params.includes('try=again')) {
	alert('회원정보를 확인하세요.');	
}

$(window).keypress(e => {
	if(e.keyCode === 13) {
		checkForm($('form')[0]);
	}
});

function checkForm(form) {
	if($('#id').val() !== "" && $('#password').val() !== "") {
		const str = encryptData($('#password').val(), key($('#id').val()))
		$('#password').val(str);
		form.submit();
	} else {
		alert('양식을 모두 작성해주세요.');
	}
}

function key(id) {
	let key = null;

	$.ajax({
		"url": `http://localhost:8081/service?command=findkey&id=${id}`,
		"method": "POST",
		"timeout": 0,
		"async" : false
	}).done(function(response) {
		key = response;
	});

	return key;
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