package com.cbaeza.challenger;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;

import com.cbaeza.challenger.model.Action;
import com.cbaeza.challenger.model.ItemType;

public class ServletAppIT {

  private static String URL = "http://localhost:8080/webapp/";

  @Test
  public void testPostCreateServer() throws Exception {
    HttpClient client = new HttpClient();
    PostMethod method = new PostMethod(
        URL + "?action=" + Action.CREATE + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
            + ItemType.SERVER);
    try {
      int statusCode = client.executeMethod(method);
      assertEquals("HTTP POST success", HttpStatus.SC_OK, statusCode);
      String response = method.getResponseBodyAsString(1000);
      assertTrue("Unexpected message", response.contains("CREATE"));
      assertTrue("Unexpected message", response.contains("PROCESSED"));
      assertTrue("Unexpected message", response.contains("SERVER"));
    } finally {
      method.releaseConnection();
    }
  }

  @Test
  public void testPostCreateStorage() throws Exception {
    HttpClient client = new HttpClient();
    PostMethod method = new PostMethod(
        URL + "?action=" + Action.CREATE + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
            + ItemType.STORAGE);
    try {
      int statusCode = client.executeMethod(method);
      assertEquals("HTTP POST success", HttpStatus.SC_OK, statusCode);
      String response = method.getResponseBodyAsString(1000);
      assertTrue("Unexpected message", response.contains("CREATE"));
      assertTrue("Unexpected message", response.contains("PROCESSED"));
      assertTrue("Unexpected message", response.contains("STORAGE"));
    } finally {
      method.releaseConnection();
    }
  }

  @Test
  public void testPostDeleteServer() throws Exception {
    HttpClient client = new HttpClient();
    PostMethod method = new PostMethod(
        URL + "?action=" + Action.DELETE + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
            + ItemType.SERVER);
    try {
      int statusCode = client.executeMethod(method);
      assertEquals("HTTP POST success", HttpStatus.SC_OK, statusCode);
      String response = method.getResponseBodyAsString(1000);
      assertTrue("Unexpected message", response.contains("DELETE"));
      assertTrue("Unexpected message", response.contains("PROCESSED"));
      assertTrue("Unexpected message", response.contains("SERVER"));
    } finally {
      method.releaseConnection();
    }
  }

  @Test
  public void testPostDeleteStorage() throws Exception {
    HttpClient client = new HttpClient();
    PostMethod method = new PostMethod(
        URL + "?action=" + Action.DELETE + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
            + ItemType.STORAGE);
    try {
      int statusCode = client.executeMethod(method);
      assertEquals("HTTP POST success", HttpStatus.SC_OK, statusCode);
      String response = method.getResponseBodyAsString(1000);
      assertTrue("Unexpected message", response.contains("DELETE"));
      assertTrue("Unexpected message", response.contains("PROCESSED"));
      assertTrue("Unexpected message", response.contains("STORAGE"));
    } finally {
      method.releaseConnection();
    }
  }

  @Test
  public void testPostDeleteDataCenter() throws Exception {
    HttpClient client = new HttpClient();
    PostMethod method = new PostMethod(
        URL + "?action=" + Action.DELETE + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
            + ItemType.DATACENTER);
    try {
      int statusCode = client.executeMethod(method);
      assertEquals("HTTP POST success", HttpStatus.SC_OK, statusCode);
      String response = method.getResponseBodyAsString(1000);
      assertTrue("Unexpected message", response.contains("DELETE"));
      assertTrue("Unexpected message", response.contains("PROCESSED"));
      assertTrue("Unexpected message", response.contains("DATACENTER"));
    } finally {
      method.releaseConnection();
    }
  }

  @Test
  public void testPostAttachStorage() throws Exception {
    HttpClient client = new HttpClient();
    PostMethod method = new PostMethod(
        URL + "?action=" + Action.ATTACH + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
            + ItemType.STORAGE);
    try {
      int statusCode = client.executeMethod(method);
      assertEquals("HTTP POST success", HttpStatus.SC_OK, statusCode);
      String response = method.getResponseBodyAsString(1000);
      assertTrue("Unexpected message", response.contains("ATTACH"));
      assertTrue("Unexpected message", response.contains("PROCESSED"));
      assertTrue("Unexpected message", response.contains("STORAGE"));
    } finally {
      method.releaseConnection();
    }
  }

  @Test
  public void testPostDetachStorage() throws Exception {
    HttpClient client = new HttpClient();
    PostMethod method = new PostMethod(
        URL + "?action=" + Action.DETACH + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
            + ItemType.STORAGE);
    try {
      int statusCode = client.executeMethod(method);
      assertEquals("HTTP POST success", HttpStatus.SC_OK, statusCode);
      String response = method.getResponseBodyAsString(1000);
      assertTrue("Unexpected message", response.contains("DETACH"));
      assertTrue("Unexpected message", response.contains("PROCESSED"));
      assertTrue("Unexpected message", response.contains("STORAGE"));
    } finally {
      method.releaseConnection();
    }
  }

  @Test
  public void testPostUpdateServer() throws Exception {
    HttpClient client = new HttpClient();
    PostMethod method = new PostMethod(
        URL + "?action=" + Action.UPDATE + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
            + ItemType.SERVER);
    try {
      int statusCode = client.executeMethod(method);
      assertEquals("HTTP POST success", HttpStatus.SC_OK, statusCode);
      String response = method.getResponseBodyAsString(1000);
      assertTrue("Unexpected message", response.contains("UPDATE"));
      assertTrue("Unexpected message", response.contains("PROCESSED"));
      assertTrue("Unexpected message", response.contains("SERVER"));
    } finally {
      method.releaseConnection();
    }
  }

  @Test
  public void testPostUpdateStorage() throws Exception {
    HttpClient client = new HttpClient();
    PostMethod method = new PostMethod(
        URL + "?action=" + Action.UPDATE + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
            + ItemType.STORAGE);
    try {
      int statusCode = client.executeMethod(method);
      assertEquals("HTTP POST success", HttpStatus.SC_OK, statusCode);
      String response = method.getResponseBodyAsString(1000);
      assertTrue("Unexpected message", response.contains("UPDATE"));
      assertTrue("Unexpected message", response.contains("PROCESSED"));
      assertTrue("Unexpected message", response.contains("STORAGE"));
    } finally {
      method.releaseConnection();
    }
  }

  @Test
  public void testPostTakeSnapshotOfStorage() throws Exception {
    HttpClient client = new HttpClient();
    PostMethod method = new PostMethod(
        URL + "?action=" + Action.TAKE_SNAPSHOT_OF_STORAGE
            + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType=" + ItemType.STORAGE);
    try {
      int statusCode = client.executeMethod(method);
      assertEquals("HTTP POST success", HttpStatus.SC_OK, statusCode);
      String response = method.getResponseBodyAsString(1000);
      assertTrue("Unexpected message", response.contains("TAKE_SNAPSHOT_OF_STORAGE"));
      assertTrue("Unexpected message", response.contains("PROCESSED"));
      assertTrue("Unexpected message", response.contains("STORAGE"));
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
      assertTrue("Unexpected message",
          response.contains("Please send a Http POST message with valid data and non null values"));
    } finally {
      method.releaseConnection();
    }
  }
}