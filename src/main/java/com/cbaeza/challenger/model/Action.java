package com.cbaeza.challenger.model;

public enum Action {
  /**
   * Action create
   */
  CREATE("create"),
  /**
   * Action update
   */
  UPDATE("update"),
  /**
   * Action delete
   */
  DELETE("delete"),
  /**
   * Action make snapshot
   */
  MAKE_SNAPSHOT("make_snapshot");

  private String value;

  Action(String value) {
    this.value = value;
  }

  public static Action fromValue(String value) {
    for (Action action : values()) {
      if (action.value().equalsIgnoreCase(value)) {
        return action;
      }
    }
    return null;
  }

  public String value() {
    return value;
  }

}
