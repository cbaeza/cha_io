package com.cbaeza.challenger;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.junit.Test;

import com.cbaeza.challenger.model.Action;
import com.cbaeza.challenger.model.ItemType;

/**
 * Integration test for {@link ServletApp}
 */
public class ServletAppIT {

  private static String URL = "http://localhost:8080/webapp/";

  @Test
  public void testCreateServer() throws Exception {
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
  public void testCreateStorage() throws Exception {
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
  public void testDeleteServer() throws Exception {
    HttpClient client = new HttpClient();
    DeleteMethod method = new DeleteMethod(
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
  public void testDeleteStorage() throws Exception {
    HttpClient client = new HttpClient();
    DeleteMethod method = new DeleteMethod(
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
  public void testDeleteDataCenter() throws Exception {
    HttpClient client = new HttpClient();
    DeleteMethod method = new DeleteMethod(
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
  public void testAttachStorage() throws Exception {
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
  public void testDetachStorage() throws Exception {
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
  public void testUpdateServer() throws Exception {
    HttpClient client = new HttpClient();
    PutMethod method = new PutMethod(
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
  public void testUpdateStorage() throws Exception {
    HttpClient client = new HttpClient();
    PutMethod method = new PutMethod(
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
  public void testTakeSnapshotOfStorage() throws Exception {
    HttpClient client = new HttpClient();
    GetMethod method = new GetMethod(
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
  public void testInValidRequest() throws Exception {
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