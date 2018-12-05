package com.cbaeza.challenger.service;

import com.cbaeza.challenger.model.Item;
import com.cbaeza.challenger.model.ItemType;

/**
 * Item service responsible to retrieve items
 * 
 * @since 1.0
 */
public class ItemService {

  /**
   * Retrieve a item given parameters
   *
   * @param itemId the item id
   * @param itemType the {@link ItemType}
   * @return a {@link Item} if found. Otherwise null
   */
  public Item retrieveItem(String itemId, ItemType itemType) {
    if (itemId != null && itemType != null) {
      // some example item of DB
      return new Item(itemId, "some item", itemType);
    } else {
      return null;
    }
  }

}
