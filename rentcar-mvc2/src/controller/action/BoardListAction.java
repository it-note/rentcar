package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.controller.BoardDao;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDao boardDao = BoardDao.getInstance();
		ArrayList<Board> list = boardDao.getBoardAll();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("boardlist").forward(request, response);
	}

}
