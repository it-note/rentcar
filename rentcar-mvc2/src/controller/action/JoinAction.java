package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.Client;
import client.ClientRequestDto;
import client.controller.ClientDao;
import key.Key;
import key.controller.KeyDao;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String zonecode = request.getParameter("zonecode");
		String address = request.getParameter("address");
		String subaddress = request.getParameter("subaddress");
		
		ClientRequestDto ClientDto = new ClientRequestDto(id, password, name, phone, zonecode, address, subaddress, subaddress);
		
		ClientDao clientDao = ClientDao.getInstance();
		clientDao.createClient(ClientDto);
		
		Client client = clientDao.getClientById(id);
		if(client != null) {
			KeyDao keyDao = KeyDao.getInstance();
			String key = request.getParameter("key");
			keyDao.createKey(new Key(client.getClientId(), key));
			
			response.sendRedirect("login?id=" + id);
		}
		else {
			response.sendRedirect("join");
		}
		
	}

}
