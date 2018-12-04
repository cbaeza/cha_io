package com.cbaeza.challenger;

import java.io.IOException;
import java.util.logging.Logger;

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

  private static Logger LOG = Logger.getLogger(ServletApp.class.getName());

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    ResponseUtils.printHelp(resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    RequestDto request = RequestUtils.createRequest(req);
    LOG.info("request " + request);
    if (request == null) {
      ResponseUtils.fail(resp);
    } else {
      LockingDelimiterService lockingDelimiterService = new LockingDelimiterService();
      ResponseDto responseDto = lockingDelimiterService.processRequest(request);
      ResponseUtils.ok(resp, responseDto);
    }
  }

  @Override
  public void init() throws ServletException {
    LOG.info("INIT " + System.currentTimeMillis());
  }

}