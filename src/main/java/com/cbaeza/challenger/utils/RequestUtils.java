package com.cbaeza.challenger.utils;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.cbaeza.challenger.dto.RequestDto;
import com.cbaeza.challenger.model.Action;
import com.cbaeza.challenger.model.ItemType;

/**
 * Request utils
 * 
 * @since 1.0
 */
public class RequestUtils {

  private static Logger LOG = Logger.getLogger(RequestUtils.class.getName());
  private static final String ATTACH_TO_SERVER_ID = "attachToServerId";
  private static final String ITEM_ID = "itemId";
  private static final String DATA_CENTER_ID = "dataCenterId";
  private static final String ACTION = "action";
  private static final String ITEM_TYPE = "itemType";

  /**
   * Create the {@link RequestDto} extracting data coming into the
   * {@link HttpServletRequest}
   * 
   * @param req the {@link HttpServletRequest}
   * @return a {@link RequestDto}
   */
  public static RequestDto createRequest(HttpServletRequest req) {
    Action action = extractCommand(req);
    String dataCenterId = extractDataCenterId(req);
    String itemId = extractItemId(req);
    String attachToServerId = extractAttachToServerId(req);
    ItemType itemType = extractItemType(req);
    LOG.info("action " + action + ", dataCenterId " + dataCenterId + ", itemId " + itemId + ", attachToServerId "
        + attachToServerId + ", itemType " + itemType);
    if (action == null || dataCenterId == null || itemId == null || attachToServerId == null || itemType == null) {
      return null;
    }
    return new RequestDto(dataCenterId, itemType, itemId, attachToServerId, action);
  }

  /**
   * Extract the parameter ATTACH_TO_SERVER_ID if available in the request
   * 
   * @param req the {@link HttpServletRequest}
   * @return a string o null
   */
  private static String extractAttachToServerId(HttpServletRequest req) {
    return req.getParameter(ATTACH_TO_SERVER_ID);
  }

  /**
   * Extract the parameter ITEM_ID if available in the request
   *
   * @param req the {@link HttpServletRequest}
   * @return a string o null
   */
  private static String extractItemId(HttpServletRequest req) {
    return req.getParameter(ITEM_ID);
  }

  /**
   * Extract the parameter DATA_CENTER_ID if available in the request
   *
   * @param req the {@link HttpServletRequest}
   * @return a string o null
   */
  private static String extractDataCenterId(HttpServletRequest req) {
    return req.getParameter(DATA_CENTER_ID);
  }

  /**
   * Extract the parameter ACTION if available in the request and map this to the
   * {@link Action} value.
   *
   * @param req the {@link HttpServletRequest}
   * @return a {@link Action} o null
   */
  private static Action extractCommand(HttpServletRequest req) {
    String action = req.getParameter(ACTION);
    if (action == null) {
      return null;
    }
    return Action.fromValue(action);
  }

  /**
   * Extract the parameter ITEM_TYPE if available in the request and map this to
   * the {@link ItemType} value.
   *
   * @param req the {@link HttpServletRequest}
   * @return a {@link ItemType} o null
   */
  private static ItemType extractItemType(HttpServletRequest req) {
    String itemType = req.getParameter(ITEM_TYPE);
    if (itemType == null) {
      return null;
    }
    return ItemType.fromValue(itemType);
  }

}
