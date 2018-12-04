package com.cbaeza.challenger.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpStatus;

import com.cbaeza.challenger.dto.RequestDto;
import com.cbaeza.challenger.dto.ResponseDto;

public class ResponseUtils {

  public static ResponseDto success(RequestDto requestDto, String status, String message) {
    return new ResponseDto(
        requestDto.getDataCenterId(),
        requestDto.getItemType(),
        requestDto.getItemId(),
        requestDto.getAttachToServerId(),
        requestDto.getAction(),
        status,
        message);
  }

  public static void fail(HttpServletResponse resp) throws IOException {
    resp.setStatus(HttpStatus.SC_BAD_REQUEST);
    printHelp(resp);
  }

    public static void printHelp(HttpServletResponse resp) throws IOException {
    resp.setStatus(HttpStatus.SC_OK);
    printInfo(resp);
  }

  private static void printInfo(HttpServletResponse resp) throws IOException {
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>Server </h1>");
    out.println("Please send a Http POST message with valid data and non null values<br>");
    out.println("Supported request parameter values are:<br>");
    out.println("<ul><li>dataCenterId: any string</li>");
    out.println("<li>itemType: DATACENTER, SERVER, STORAGE</li>");
    out.println("<li>itemId: any string</li>");
    out.println("<li>attachToServerId: any string</li>");
    out.println("<li>attachToServerId: any string</li>");
    out.println("<li>action: CREATE, UPDATE, DELETE, MAKE_SNAPSHOT</li></ul>");
    out.println("</body>");
    out.println("</html>");
  }

  public static void ok(HttpServletResponse resp, ResponseDto responseDto) throws IOException {
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>Server OK </h1>");
    out.println("<h2>" + responseDto.toString() + "</h3>");
    out.println("</body>");
    out.println("</html>");
  }
}
