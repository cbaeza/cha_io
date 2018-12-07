package com.cbaeza.challenger;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cbaeza.challenger.dataaccess_layer.MockedProvisioningBackend;
import com.cbaeza.challenger.dto.RequestDto;
import com.cbaeza.challenger.dto.ResponseDto;
import com.cbaeza.challenger.service.ItemService;
import com.cbaeza.challenger.service.LockingDelimiterService;
import com.cbaeza.challenger.utils.RequestUtils;
import com.cbaeza.challenger.utils.ResponseUtils;

/**
 * Main entry point of the IONOS coding challenge
 * 
 * @since 1.0
 */
public class ServletApp extends HttpServlet {

  private static Logger LOG = Logger.getLogger(ServletApp.class.getName());

  /**
   * To handler action:<br>
   * Take a Snapshot of storage
   *
   * @param req the {@link HttpServletRequest}
   * @param resp the {@link HttpServletResponse}
   * @throws IOException throws IOException
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    process(req, resp);
  }

  /**
   * To handler action:<br>
   * - Create Server or Storage. <br>
   * - Attach or Detach Storage to/from Server<br>
   *
   * @param req the {@link HttpServletRequest}
   * @param resp the {@link HttpServletResponse}
   * @throws IOException throws IOException
   */
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    process(req, resp);
  }

  /**
   * To handler action:<br>
   * - Update server or store
   *
   * @param req the {@link HttpServletRequest}
   * @param resp the {@link HttpServletResponse}
   * @throws IOException throws IOException
   */
  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    process(req, resp);
  }

  /**
   * To handler action:<br>
   * - Delete Server, Storage or Datacenter
   *
   * @param req the {@link HttpServletRequest}
   * @param resp the {@link HttpServletResponse}
   * @throws IOException throws IOException
   */
  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    process(req, resp);
  }

  /**
   * Process the incoming request
   *
   * @param req the {@link HttpServletRequest}
   * @param resp the {@link HttpServletResponse}
   * @throws IOException IOException throws IOException
   */
  private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    RequestDto request = RequestUtils.createRequest(req);
    LOG.info("request " + request);
    if (request == null) {
      ResponseUtils.fail(resp);
    } else {
      LockingDelimiterService lockingDelimiterService = new LockingDelimiterService(new MockedProvisioningBackend(),
          new ItemService());
      ResponseDto responseDto = lockingDelimiterService.processRequest(request);
      ResponseUtils.ok(resp, responseDto);
    }
  }

}