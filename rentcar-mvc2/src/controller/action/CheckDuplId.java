package controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import client.Client;
import client.controller.ClientDao;

public class CheckDuplId implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result = false;
		String id = request.getParameter("id").trim();

		ClientDao clientDao = ClientDao.getInstance();
		Client client = clientDao.getClientById(id);
		
		if(client != null)
			result = true;
		
		JSONObject data = new JSONObject();
		data.put("result", result);
		
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		out.print(data);
		out.flush();
		
	}

}
