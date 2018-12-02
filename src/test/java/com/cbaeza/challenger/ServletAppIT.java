package com.cbaeza.challenger;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;

public class ServletAppIT {

  private static String URL = "http://localhost:8080/webapp/";

  @Test
  public void testPostValidRequest() throws Exception {
    HttpClient client = new HttpClient();
    PostMethod method = new PostMethod(
        URL + "?action=CREATE&dataCenterId=1&itemId=100&attachToServerId=999&itemType=DATACENTER");
    try {
      int statusCode = client.executeMethod(method);
      assertEquals("HTTP POST success", HttpStatus.SC_OK, statusCode);
      String response = method.getResponseBodyAsString(1000);
      assertTrue("Unexpected message", response.contains("Server OK"));
    } finally {
      method.releaseConnection();
    }
  }

  @Test
  public void testPostInValidRequest() throws Exception {
    HttpClient client = new HttpClient();
    PostMethod method = new PostMethod(URL);
    try {
      int statusCode = client.executeMethod(method);
      assertEquals("HTTP GET failed", HttpStatus.SC_BAD_REQUEST, statusCode);
      String response = method.getResponseBodyAsString(1000);
      assertTrue("Unexpected message", response.contains("FAIL"));
    } finally {
      method.releaseConnection();
    }
  }
}