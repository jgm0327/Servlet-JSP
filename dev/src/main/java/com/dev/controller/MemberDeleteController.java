package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;

public class MemberDeleteController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		String id = request.getParameter("id");
		MemberService service = MemberService.getInstance();
		service.memberDelete(id);
		HttpUtil.forward(request, reponse, "/result/memberDeleteOutput.jsp");
	}

}
