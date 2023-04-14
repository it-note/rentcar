package controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class GenerateKeyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");

		JSONObject obj = new JSONObject();
		obj.put("key", createCode());

		PrintWriter out = response.getWriter();
		out.print(obj);
		out.flush();

	}

	private String createCode() {
		Random random = new Random();
		StringBuffer key = new StringBuffer();

		for (int i = 0; i < 8; i++) {
			int index = random.nextInt(3);

			switch (index) {
			case 0:
				key.append((char) ((int) random.nextInt(26) + 97));
				break;
			case 1:
				key.append((char) ((int) random.nextInt(26) + 65));
				break;
			case 2:
				key.append(random.nextInt(9));
				break;
			}
		}
		return key.toString();
	}

}
