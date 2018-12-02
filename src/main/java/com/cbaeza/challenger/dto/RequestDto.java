package com.cbaeza.challenger.dto;

import com.cbaeza.challenger.model.Action;
import com.cbaeza.challenger.model.ItemType;

public class RequestDto {

  private final String dataCenterId;
  private final ItemType itemType;
  private final String itemId;
  private final String attachToServerId;
  private final Action action;

  public RequestDto(
      String dataCenterId,
      ItemType itemType,
      String itemId,
      String attachToServerId,
      Action action) {
    this.dataCenterId = dataCenterId;
    this.itemType = itemType;
    this.itemId = itemId;
    this.attachToServerId = attachToServerId;
    this.action = action;
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

  @Override
  public String toString() {
    return "RequestDto{" +
        "dataCenterId='" + dataCenterId + '\'' +
        ", itemType=" + itemType +
        ", itemId='" + itemId + '\'' +
        ", attachToServerId='" + attachToServerId + '\'' +
        ", action=" + action +
        '}';
  }
}
