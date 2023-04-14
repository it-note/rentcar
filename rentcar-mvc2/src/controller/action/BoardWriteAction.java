package controller.action;

import java.io.IOException;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardRequestDto;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int clientId = Integer.parseInt(request.getParameter("clientId"));
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String type = null;
		Blob image = null;
		String file = request.getParameter("file");
		int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
		
		BoardRequestDto boardDto = new BoardRequestDto(clientId, title, contents, image, type, vehicleId);
		
		System.out.println(clientId);
		System.out.println(title);
		System.out.println(contents);
		System.out.println(type);
		System.out.println(image);
		System.out.println(file);
		System.out.println(vehicleId);
	}

}
