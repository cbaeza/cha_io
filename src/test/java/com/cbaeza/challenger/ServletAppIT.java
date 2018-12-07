package com.cbaeza.challenger;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.post;
import static io.restassured.RestAssured.put;
import static junit.framework.TestCase.assertTrue;

import org.junit.Test;

import com.cbaeza.challenger.model.Action;
import com.cbaeza.challenger.model.ItemType;

/**
 * Integration test for {@link ServletApp}
 */
public class ServletAppIT {

  private static String URL = "http://localhost:8080/webapp/";

  @Test
  public void testWithAssure() {
    String body = get(URL + "?action=" + Action.CREATE + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
        + ItemType.SERVER).then().statusCode(200).extract().body().asString();
    assertTrue("Unexpected message", body.contains("CREATE"));
    assertTrue("Unexpected message", body.contains("PROCESSED"));
    assertTrue("Unexpected message", body.contains("SERVER"));
  }

  @Test
  public void testCreateServer() {
    String body = post(URL + "?action=" + Action.CREATE + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
        + ItemType.SERVER).then().statusCode(200).extract().body().asString();
    assertTrue("Unexpected message", body.contains("CREATE"));
    assertTrue("Unexpected message", body.contains("PROCESSED"));
    assertTrue("Unexpected message", body.contains("SERVER"));
  }

  @Test
  public void testCreateStorage() {
    String body = post(URL + "?action=" + Action.CREATE + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
        + ItemType.STORAGE).then().statusCode(200).extract().body().asString();
    assertTrue("Unexpected message", body.contains("CREATE"));
    assertTrue("Unexpected message", body.contains("PROCESSED"));
    assertTrue("Unexpected message", body.contains("STORAGE"));
  }

  @Test
  public void testDeleteServer() {
    String body = delete(URL + "?action=" + Action.DELETE + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
        + ItemType.SERVER).then().statusCode(200).extract().body().asString();
    assertTrue("Unexpected message", body.contains("DELETE"));
    assertTrue("Unexpected message", body.contains("PROCESSED"));
    assertTrue("Unexpected message", body.contains("SERVER"));
  }

  @Test
  public void testDeleteStorage() {
    String body = delete(URL + "?action=" + Action.DELETE + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
        + ItemType.STORAGE).then().statusCode(200).extract().body().asString();
    assertTrue("Unexpected message", body.contains("DELETE"));
    assertTrue("Unexpected message", body.contains("PROCESSED"));
    assertTrue("Unexpected message", body.contains("STORAGE"));
  }

  @Test
  public void testDeleteDataCenter() {
    String body = delete(URL + "?action=" + Action.DELETE + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
        + ItemType.DATACENTER).then().statusCode(200).extract().body().asString();
    assertTrue("Unexpected message", body.contains("DELETE"));
    assertTrue("Unexpected message", body.contains("PROCESSED"));
    assertTrue("Unexpected message", body.contains("DATACENTER"));
  }

  @Test
  public void testAttachStorage() {
    String body = post(URL + "?action=" + Action.ATTACH + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
        + ItemType.STORAGE).then().statusCode(200).extract().body().asString();
    assertTrue("Unexpected message", body.contains("ATTACH"));
    assertTrue("Unexpected message", body.contains("PROCESSED"));
    assertTrue("Unexpected message", body.contains("STORAGE"));
  }

  @Test
  public void testDetachStorage() {
    String body = post(URL + "?action=" + Action.DETACH + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
        + ItemType.STORAGE).then().statusCode(200).extract().body().asString();
    assertTrue("Unexpected message", body.contains("DETACH"));
    assertTrue("Unexpected message", body.contains("PROCESSED"));
    assertTrue("Unexpected message", body.contains("STORAGE"));
  }

  @Test
  public void testUpdateServer() {
    String body = put(URL + "?action=" + Action.UPDATE + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
        + ItemType.SERVER).then().statusCode(200).extract().body().asString();
    assertTrue("Unexpected message", body.contains("UPDATE"));
    assertTrue("Unexpected message", body.contains("PROCESSED"));
    assertTrue("Unexpected message", body.contains("SERVER"));
  }

  @Test
  public void testUpdateStorage() {
    String body = put(URL + "?action=" + Action.UPDATE + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType="
        + ItemType.STORAGE).then().statusCode(200).extract().body().asString();
    assertTrue("Unexpected message", body.contains("UPDATE"));
    assertTrue("Unexpected message", body.contains("PROCESSED"));
    assertTrue("Unexpected message", body.contains("STORAGE"));
  }

  @Test
  public void testTakeSnapshotOfStorage() {
    String body = get(URL + "?action=" + Action.TAKE_SNAPSHOT_OF_STORAGE
        + "&dataCenterId=1&itemId=100&attachToServerId=999&itemType=" + ItemType.STORAGE).then().statusCode(200)
            .extract().body().asString();
    assertTrue("Unexpected message", body.contains("TAKE_SNAPSHOT_OF_STORAGE"));
    assertTrue("Unexpected message", body.contains("PROCESSED"));
    assertTrue("Unexpected message", body.contains("STORAGE"));
  }

  @Test
  public void testInValidRequest() {
    post(URL).then().statusCode(400);
  }
}