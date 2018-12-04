package com.cbaeza.challenger.model;

public class Item {

  private String id;
  private String description;

  public Item(String id, String description) {
    this.id = id;
    this.description = description;
  }

  public static Item empty() {
    return new Item("", "");
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "Item{" +
        "id='" + id + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
