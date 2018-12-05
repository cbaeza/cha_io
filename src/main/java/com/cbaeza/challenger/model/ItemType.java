package com.cbaeza.challenger.model;

/**
 * Enum to represent a ItemType
 *
 * @since 1.0
 */
public enum ItemType {
  /**
   * A data center
   */
  DATACENTER("dataCenter"),
  /**
   * A Server
   */
  SERVER("server"),
  /**
   * A Storage
   */
  STORAGE("storage");

  private String value;

  ItemType(String value) {
    this.value = value;
  }

  public static ItemType fromValue(String value) {
    for (ItemType itemType : values()) {
      if (itemType.value().equalsIgnoreCase(value)) {
        return itemType;
      }
    }
    return null;
  }

  public String value() {
    return value;
  }
}
