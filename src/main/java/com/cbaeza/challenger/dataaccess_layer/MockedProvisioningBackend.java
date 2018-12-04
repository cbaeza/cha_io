package com.cbaeza.challenger.dataaccess_layer;

import java.util.logging.Logger;

import com.cbaeza.challenger.dto.RequestDto;
import com.cbaeza.challenger.model.Item;

public class MockedProvisioningBackend {
  private static Logger LOG = Logger.getLogger(MockedProvisioningBackend.class.getName());

  public boolean forwardItem(Item item, RequestDto request) {
    // let made some validation
    if (item == null) {
      return false;
    }

    switch (request.getAction()) {
    case CREATE:
      handlerCreate(item, request);
      break;
    case UPDATE:
      handlerUpdate(item, request);
      break;
    case MAKE_SNAPSHOT:
      handlerMakeSnapshot(item, request);
      break;
    case DELETE:
      handlerDelete(item, request);
      break;
    default:
      return true;
    }
    // finish with success
    return true;
  }

  private void handlerCreate(Item item, RequestDto request) {
    try {
      // take some time to process
      Thread.sleep(150);
      LOG.info("Item success on " + request.getAction() + " -> " + item);
    } catch (InterruptedException e) {
      LOG.info("InterruptedException calling handlerCreate");
    }
  }

  private void handlerUpdate(Item item, RequestDto request) {
    try {
      // take some time to process
      Thread.sleep(1500);
      LOG.info("Item success on " + request.getAction() + " -> " + item);
    } catch (InterruptedException e) {
      LOG.info("InterruptedException calling handlerUpdate");
    }
  }

  private void handlerMakeSnapshot(Item item, RequestDto request) {
    try {
      // take some time to process
      Thread.sleep(500);
      LOG.info("Item success on " + request.getAction() + " -> " + item);
    } catch (InterruptedException e) {
      LOG.info("InterruptedException calling handlerMakeSnapshot");
    }
  }

  private void handlerDelete(Item item, RequestDto request) {
    try {
      // take some time to process
      Thread.sleep(1000);
      LOG.info("Item success on " + request.getAction() + " -> " + item);
    } catch (InterruptedException e) {
      LOG.info("InterruptedException calling handlerDelete");
    }
  }

}
