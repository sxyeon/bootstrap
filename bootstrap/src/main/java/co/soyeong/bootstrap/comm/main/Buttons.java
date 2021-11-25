package co.soyeong.bootstrap.comm.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.soyeong.bootstrap.comm.Command;

public class Buttons implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		return "main/buttons";
	}

}
