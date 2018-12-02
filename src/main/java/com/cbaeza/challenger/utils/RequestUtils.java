package com.cbaeza.challenger.utils;

import javax.servlet.http.HttpServletRequest;

import com.cbaeza.challenger.dto.RequestDto;
import com.cbaeza.challenger.model.Action;
import com.cbaeza.challenger.model.ItemType;

public class RequestUtils {

  private static final String ATTACH_TO_SERVER_ID = "attachToServerId";
  private static final String ITEM_ID = "itemId";
  private static final String DATA_CENTER_ID = "dataCenterId";
  private static final String ACTION = "action";
  private static final String ITEM_TYPE = "itemType";

  public static RequestDto createRequest(HttpServletRequest req) {
    Action action = extractCommand(req);
    String dataCenterId = extractDataCenterId(req);
    String itemId = extractItemId(req);
    String attachToServerId = extractAttachToServerId(req);
    ItemType itemType = extractItemType(req);
    System.out.println("action " + action);
    System.out.println("dataCenterId " + dataCenterId);
    System.out.println("itemId " + itemId);
    System.out.println("attachToServerId " + attachToServerId);
    System.out.println("itemType " + itemType);
    if (action == null || dataCenterId == null || itemId == null || attachToServerId == null || itemType == null) {
      return null;
    }
    return new RequestDto(dataCenterId, itemType, itemId, attachToServerId, action);
  }

  private static String extractAttachToServerId(HttpServletRequest req) {
    return req.getParameter(ATTACH_TO_SERVER_ID);
  }

  private static String extractItemId(HttpServletRequest req) {
    return req.getParameter(ITEM_ID);
  }

  private static String extractDataCenterId(HttpServletRequest req) {
    return req.getParameter(DATA_CENTER_ID);
  }

  private static Action extractCommand(HttpServletRequest req) {
    String action = req.getParameter(ACTION);
    if (action == null) {
      return null;
    }
    return Action.fromValue(action);
  }

  private static ItemType extractItemType(HttpServletRequest req) {
    String itemType = req.getParameter(ITEM_TYPE);
    if (itemType == null) {
      return null;
    }
    return ItemType.fromValue(itemType);
  }

}
