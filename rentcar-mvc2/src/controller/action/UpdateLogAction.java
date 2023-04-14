package controller.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import booking.Booking;
import booking.controller.BookingDao;
import client.Client;
import client.controller.ClientDao;

public class UpdateLogAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("log") != null) {
			session.removeAttribute("log");
			response.sendRedirect("/");
		} else {
				String id = request.getParameter("id");
				String password = request.getParameter("password");
				
				ClientDao clientDao = ClientDao.getInstance();
				Client client = clientDao.getClientById(id);

				if (client != null && password.equals(client.getPassword())) {
					Client log = new Client(client.getClientId(), client.getId(), client.getName(), client.getType());
					session.setAttribute("log", log);

					BookingDao bookDao = BookingDao.getInstance();
					ArrayList<Booking> list = bookDao.getBookingByClientIdAll(client.getClientId());

					session.setAttribute("booklist", list);

					response.sendRedirect("mypage");
				} else if (id != null) {
					response.sendRedirect("login?try=again");
				} else {
					response.sendRedirect("login");
				}
		}
	}
}
