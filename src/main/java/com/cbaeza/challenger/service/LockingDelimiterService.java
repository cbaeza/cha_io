package com.cbaeza.challenger.service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.cbaeza.challenger.dataaccess_layer.MockedProvisioningBackend;
import com.cbaeza.challenger.dto.RequestDto;
import com.cbaeza.challenger.dto.ResponseDto;
import com.cbaeza.challenger.model.Item;
import com.cbaeza.challenger.model.ItemType;
import com.cbaeza.challenger.model.Status;
import com.cbaeza.challenger.utils.ResponseUtils;

public class LockingDelimiterService {
  private final MockedProvisioningBackend mockedProvisioningBackend = new MockedProvisioningBackend();
  private final ItemService itemService = new ItemService();
  private Lock lock = new ReentrantLock();

  public LockingDelimiterService() {
  }

  public ResponseDto processRequest(RequestDto request) {
    lock.lock();
    String itemId = request.getItemId();
    ItemType itemType = request.getItemType();
    Item item = itemService.retrieveItem(itemId, itemType);
    if (item == null) {
      return ResponseUtils.success(request, Status.ITEM_NOT_FOUND,
          "Item not found");
    }
    boolean success = mockedProvisioningBackend.forwardItem(item, request);
    lock.unlock();
    if (success) {
      return ResponseUtils.success(request, Status.PROCESSED,
          "Success on " + request.getAction() + " -> " + item);
    } else {
      return ResponseUtils.success(request, Status.NO_PROCESSED,
          "Nothing has been done. Fail on MockedProvisioningBackend");
    }
  }
}
