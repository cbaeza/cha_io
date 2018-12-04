package com.cbaeza.challenger.model;

public enum Status {

  ITEM_NOT_FOUND("Item not found"), PROCESSED("Processed"), NO_PROCESSED("No processed");

  private String value;

  Status(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
