package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.Client;
import client.controller.ClientDao;
import key.controller.KeyDao;

public class FindKeyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		ClientDao clientDao = ClientDao.getInstance();
		Client client = clientDao.getClientById(id);
		
		String key = null;
		if(client != null) {
			KeyDao keyDao = KeyDao.getInstance();
			key = keyDao.getKeyByClientId(client.getClientId());
		}
	
		response.getWriter().append(key);
	}

}
