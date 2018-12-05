package com.cbaeza.challenger.dto;

import com.cbaeza.challenger.model.Action;
import com.cbaeza.challenger.model.ItemType;
import com.cbaeza.challenger.model.Status;

/**
 * Transport dto of response information
 */
public class ResponseDto {

  private final String dataCenterId;
  private final ItemType itemType;
  private final String itemId;
  private final String attachToServerId;
  private final Action action;
  private final Status status;
  private final String message;

  public ResponseDto(
      String dataCenterId,
      ItemType itemType,
      String itemId,
      String attachToServerId,
      Action action,
      Status status,
      String message) {
    this.dataCenterId = dataCenterId;
    this.itemType = itemType;
    this.itemId = itemId;
    this.attachToServerId = attachToServerId;
    this.action = action;
    this.status = status;
    this.message = message;
  }

  public String getDataCenterId() {
    return dataCenterId;
  }

  public ItemType getItemType() {
    return itemType;
  }

  public String getItemId() {
    return itemId;
  }

  public String getAttachToServerId() {
    return attachToServerId;
  }

  public Action getAction() {
    return action;
  }

  public Status getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "ResponseDto{" +
        "dataCenterId=" + dataCenterId +
        ", itemType=" + itemType +
        ", itemId='" + itemId + '\'' +
        ", attachToServerId='" + attachToServerId + '\'' +
        ", action=" + action +
        ", status='" + status + '\'' +
        ", message='" + message + '\'' +
        '}';
  }
}
