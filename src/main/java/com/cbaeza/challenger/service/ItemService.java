package com.cbaeza.challenger.service;

import com.cbaeza.challenger.model.Item;
import com.cbaeza.challenger.model.ItemType;

public class ItemService {

  public Item retrieveItem(String itemId, ItemType itemType) {
    if (itemId != null && itemType != null) {
      return new Item(itemId, "some item", itemType);
    } else {
      return null;
    }
  }

}
