package com.cbaeza.challenger.dataaccess_layer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.cbaeza.challenger.dto.RequestDto;
import com.cbaeza.challenger.model.Action;
import com.cbaeza.challenger.model.Item;
import com.cbaeza.challenger.model.ItemType;

public class MockedProvisioningBackendTest {

  private MockedProvisioningBackend mockedProvisioningBackend = new MockedProvisioningBackend();

  @Test
  public void testSuccess() {
    RequestDto requestDto = createRequestDto("1", ItemType.SERVER, "99", "2", Action.CREATE);
    Item item = new Item("99", "description", ItemType.SERVER);
    boolean success = mockedProvisioningBackend.forwardItem(item, requestDto);
    assertTrue(success);
  }

  @Test
  public void testNoSuccess() {
    RequestDto requestDto = createRequestDto("1", ItemType.SERVER, "88", "2", Action.CREATE);
    boolean success = mockedProvisioningBackend.forwardItem(null, requestDto);
    assertFalse(success);
  }

  private RequestDto createRequestDto(
      String dataCenterId,
      ItemType itemType,
      String itemId,
      String attachToServerId,
      Action action) {
    return new RequestDto(dataCenterId, itemType, itemId, attachToServerId, action);
  }

}