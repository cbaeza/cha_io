package com.cbaeza.challenger;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cbaeza.challenger.dto.RequestDto;
import com.cbaeza.challenger.dto.ResponseDto;
import com.cbaeza.challenger.service.LockingDelimiterService;
import com.cbaeza.challenger.utils.RequestUtils;
import com.cbaeza.challenger.utils.ResponseUtils;

public class ServletApp extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    RequestDto request = RequestUtils.createRequest(req);
    System.out.println("request " + request);
    if (request == null) {
      ResponseUtils.fail(resp);
    } else {
      LockingDelimiterService lockingDelimiterService = new LockingDelimiterService();
      ResponseDto responseDto = lockingDelimiterService.processRequest(request);
      ResponseUtils.ok(resp, responseDto);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    doGet(req, resp);
  }

  @Override
  public void init() throws ServletException {
    System.out.println("INIT " + System.currentTimeMillis());
  }

}