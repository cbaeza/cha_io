package com.cbaeza.challenger.service;

import com.cbaeza.challenger.model.Item;

public class ItemService {

  public Item retrieveItem(String itemId) {
    if (itemId != null) {
      return new Item(itemId, "some item");
    } else {
      return Item.empty();
    }
  }

}
