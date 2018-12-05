package com.cbaeza.challenger.dataaccess_layer;

import java.util.logging.Logger;

import com.cbaeza.challenger.dto.RequestDto;
import com.cbaeza.challenger.model.Item;

/**
 * The MockedProvisioningBackend is responsible to handle a action with the
 * {@link Item}
 *
 * @since 1.0
 */
public class MockedProvisioningBackend {
  private static Logger LOG = Logger.getLogger(MockedProvisioningBackend.class.getName());

  /**
   * Method the get a {@link Item} and process it
   *
   * @param item the {@link Item}
   * @param request the {@link RequestDto}
   * @return true if success, otherwise false
   */
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
    case ATTACH:
      handlerAttach(item, request);
      break;
    case DETACH:
      handlerDetach(item, request);
      break;
    case DELETE:
      handlerDelete(item, request);
      break;
    case TAKE_SNAPSHOT_OF_STORAGE:
      handlerTakeSnapshotOfStorage(item, request);
      break;

    default:
      return true;
    }
    // finish with success
    return true;
  }

  /**
   * Handle the action {@link com.cbaeza.challenger.model.Action.CREATE} over the
   * item {@link Item}
   * 
   * @param item the {@link Item}
   * @param request the {@link RequestDto}
   */
  private void handlerCreate(Item item, RequestDto request) {
    try {
      // take some time to process
      Thread.sleep(150);
      LOG.info("Item success on " + request.getAction() + " -> " + item);
    } catch (InterruptedException e) {
      LOG.info("InterruptedException calling handlerCreate");
    }
  }

  /**
   * Handle the action {@link com.cbaeza.challenger.model.Action.UPDATE} over the
   * item {@link Item}
   *
   * @param item the {@link Item}
   * @param request the {@link RequestDto}
   */
  private void handlerUpdate(Item item, RequestDto request) {
    try {
      // take some time to process
      Thread.sleep(1500);
      LOG.info("Item success on " + request.getAction() + " -> " + item);
    } catch (InterruptedException e) {
      LOG.info("InterruptedException calling handlerUpdate");
    }
  }

  /**
   * Handle the action {@link com.cbaeza.challenger.model.Action.ATTACH} over the
   * item {@link Item}
   *
   * @param item the {@link Item}
   * @param request the {@link RequestDto}
   */
  private void handlerAttach(Item item, RequestDto request) {
    try {
      // take some time to process
      Thread.sleep(150);
      LOG.info("Item success on " + request.getAction() + " -> " + item);
    } catch (InterruptedException e) {
      LOG.info("InterruptedException calling handlerAttach");
    }
  }

  /**
   * Handle the action {@link com.cbaeza.challenger.model.Action.DETACH} over the
   * item {@link Item}
   *
   * @param item the {@link Item}
   * @param request the {@link RequestDto}
   */
  private void handlerDetach(Item item, RequestDto request) {
    try {
      // take some time to process
      Thread.sleep(150);
      LOG.info("Item success on " + request.getAction() + " -> " + item);
    } catch (InterruptedException e) {
      LOG.info("InterruptedException calling handlerDetach");
    }
  }

  /**
   * Handle the action
   * {@link com.cbaeza.challenger.model.Action.TAKE_SNAPSHOT_OF_STORAGE} over the
   * item {@link Item}
   *
   * @param item the {@link Item}
   * @param request the {@link RequestDto}
   */
  private void handlerTakeSnapshotOfStorage(Item item, RequestDto request) {
    try {
      // take some time to process
      Thread.sleep(500);
      LOG.info("Item success on " + request.getAction() + " -> " + item);
    } catch (InterruptedException e) {
      LOG.info("InterruptedException calling handlerTakeSnapshotOfStorage");
    }
  }

  /**
   * Handle the action {@link com.cbaeza.challenger.model.Action.DELETE} over the
   * item {@link Item}
   *
   * @param item the {@link Item}
   * @param request the {@link RequestDto}
   */
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
