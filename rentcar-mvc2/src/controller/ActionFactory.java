package controller;

import controller.action.Action;
import controller.action.BoardListAction;
import controller.action.BoardWriteAction;
import controller.action.CheckDuplId;
import controller.action.CheckDuplPhone;
import controller.action.FindKeyAction;
import controller.action.GenerateKeyAction;
import controller.action.JoinAction;
import controller.action.UpdateLogAction;

public class ActionFactory {
	
	private ActionFactory() {}
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("join"))
			action = new JoinAction();
		else if(command.equals("checkduplid"))
			action = new CheckDuplId();
		else if(command.equals("checkduplphone"))
			action = new CheckDuplPhone();
		else if(command.equals("updatelog"))
			action = new UpdateLogAction();
		else if(command.equals("boardlist"))
			action = new BoardListAction();
		else if(command.equals("boardwrite"))
			action = new BoardWriteAction();
		else if(command.equals("generatekey"))
			action = new GenerateKeyAction();
		else if(command.equals("findkey"))
			action = new FindKeyAction();
		
		return action;
	}

}
