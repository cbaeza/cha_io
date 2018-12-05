package com.cbaeza.challenger.model;

/**
 * Enum to represent a status related to request processing
 *
 * @since 1.0
 */
public enum Status {

  /**
   * Item has not been found
   */
  ITEM_NOT_FOUND("Item not found"),
  /**
   * Item has been processed
   */
  PROCESSED("Processed"),
  /**
   * Item not processed
   */
  NO_PROCESSED("No processed");

  private String value;

  Status(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
