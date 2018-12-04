package com.cbaeza.challenger.model;

public class Item {

  private String id;
  private String description;
  private ItemType itemType;

  public Item(String id, String description, ItemType itemType) {
    this.id = id;
    this.description = description;
    this.itemType = itemType;
  }

  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public ItemType getItemType() {
    return itemType;
  }

  @Override
  public String toString() {
    return "Item{" +
        "id='" + id + '\'' +
        ", description='" + description + '\'' +
        ", itemType=" + itemType +
        '}';
  }
}
