package com.cbaeza.challenger.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpStatus;

import com.cbaeza.challenger.dto.RequestDto;
import com.cbaeza.challenger.dto.ResponseDto;
import com.cbaeza.challenger.model.Status;

/**
 * Response utils
 * 
 * @since 1.0
 */
public class ResponseUtils {

  /**
   * Create a {@link ResponseDto} with the given data
   *
   * @param requestDto the {@link RequestDto}
   * @param status the {@link Status}
   * @param message the message
   * @return the {@link ResponseDto}
   */
  public static ResponseDto success(RequestDto requestDto, Status status, String message) {
    return new ResponseDto(
        requestDto.getDataCenterId(),
        requestDto.getItemType(),
        requestDto.getItemId(),
        requestDto.getAttachToServerId(),
        requestDto.getAction(),
        status,
        message);
  }

  /**
   * Set the response status as OK and put the given response into the response
   * body
   *
   * @param resp the {@link HttpServletResponse}
   * @param responseDto the {@link ResponseDto}
   * @throws IOException throws IOException
   */
  public static void ok(HttpServletResponse resp, ResponseDto responseDto) throws IOException {
    resp.setStatus(HttpStatus.SC_OK);
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>Server OK </h1>");
    out.println("<h2>" + responseDto.toString() + "</h3>");
    out.println("</body>");
    out.println("</html>");
  }

  /**
   * Set the response status as bad request and print help information
   *
   * @param resp the {@link HttpServletResponse}
   * @throws IOException throws IOException
   */
  public static void fail(HttpServletResponse resp) throws IOException {
    resp.setStatus(HttpStatus.SC_BAD_REQUEST);
    printInfo(resp);
  }

  /**
   * Set the response status as OK and print help information
   *
   * @param resp the {@link HttpServletResponse}
   * @throws IOException throws IOException
   */
  public static void printHelp(HttpServletResponse resp) throws IOException {
    resp.setStatus(HttpStatus.SC_OK);
    printInfo(resp);
  }

  /**
   * Print into the response a help information to understand how to use the
   * endpoint
   * 
   * @param resp the {@link HttpServletResponse}
   * @throws IOException throws IOException
   */
  private static void printInfo(HttpServletResponse resp) throws IOException {
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>Server </h1>");
    out.println("Please send a Http POST message with valid data and non null values.<br>");
    out.println("Supported request parameter values are:<br>");
    out.println("<ul><li>dataCenterId: any string</li>");
    out.println("<li>itemType: DATACENTER, SERVER, STORAGE</li>");
    out.println("<li>itemId: any string</li>");
    out.println("<li>attachToServerId: any string</li>");
    out.println("<li>attachToServerId: any string</li>");
    out.println("<li>action: CREATE, UPDATE, DELETE, TAKE_SNAPSHOT_OF_STORAGE</li></ul>");
    out.println("</body>");
    out.println("</html>");
  }

}
