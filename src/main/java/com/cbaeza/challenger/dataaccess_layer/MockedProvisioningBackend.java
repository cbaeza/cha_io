package com.cbaeza.challenger.dataaccess_layer;

import java.util.logging.Logger;

import com.cbaeza.challenger.model.Item;

public class MockedProvisioningBackend {
  private static Logger LOG = Logger.getLogger(MockedProvisioningBackend.class.getName());

  public boolean forwardItem(Item item) {
    // let made some validation
    if (item == null) {
      return false;
    }
    try {
      // take some time to process (1 second)
      Thread.sleep(1000);
      LOG.info("Item success processed -> " + item);
    } catch (InterruptedException e) {
      LOG.info("InterruptedException calling MockedProvisioningBackend");
    }
    // all time finish with success
    return true;
  }
}
