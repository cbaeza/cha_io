package com.cbaeza.challenger.service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.cbaeza.challenger.dataaccess_layer.MockedProvisioningBackend;
import com.cbaeza.challenger.dto.RequestDto;
import com.cbaeza.challenger.dto.ResponseDto;
import com.cbaeza.challenger.model.Item;
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
    Item item = itemService.retrieveItem(itemId);
    boolean success = mockedProvisioningBackend.forwardItem(item);
    lock.unlock();

    if (success) {
      return ResponseUtils.success(request, "200", "Success processed!");
    } else {
      return ResponseUtils.success(request, "200", "Retrieved Item can't be null");
    }
  }
}
