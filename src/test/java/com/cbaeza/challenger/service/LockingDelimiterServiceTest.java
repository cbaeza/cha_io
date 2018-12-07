package com.cbaeza.challenger.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cbaeza.challenger.dataaccess_layer.MockedProvisioningBackend;
import com.cbaeza.challenger.dto.RequestDto;
import com.cbaeza.challenger.dto.ResponseDto;
import com.cbaeza.challenger.model.Action;
import com.cbaeza.challenger.model.Item;
import com.cbaeza.challenger.model.ItemType;
import com.cbaeza.challenger.model.Status;

@RunWith(MockitoJUnitRunner.class)
public class LockingDelimiterServiceTest {

  @Mock
  private MockedProvisioningBackend mockedProvisioningBackend;
  @Mock
  private ItemService itemService;

  private LockingDelimiterService lockingDelimiterService;

  @Before
  public void setUp() {
    lockingDelimiterService = new LockingDelimiterService(mockedProvisioningBackend, itemService);
  }

  @Test
  public void testNullItemNotFound() {
    RequestDto requestDto = createRequestDto("1", ItemType.SERVER, null, "2", Action.CREATE);
    ResponseDto responseDto = lockingDelimiterService.processRequest(requestDto);
    assertEquals(Status.ITEM_NOT_FOUND, responseDto.getStatus());
  }

  @Test
  public void testValidRequestProcessed() {
    RequestDto requestDto = createRequestDto("1", ItemType.SERVER, "100", "2", Action.CREATE);
    Item someItem = new Item("100", "some item", ItemType.SERVER);
    when(itemService.retrieveItem("100", ItemType.SERVER)).thenReturn(someItem);
    when(mockedProvisioningBackend.forwardItem(someItem, requestDto)).thenReturn(true);
    ResponseDto responseDto = lockingDelimiterService.processRequest(requestDto);
    assertEquals(Status.PROCESSED, responseDto.getStatus());
  }

  @Test
  public void testValidRequestNoProcessed() {
    RequestDto requestDto = createRequestDto("1", ItemType.SERVER, "100", "2", Action.DELETE);
    Item someItem = new Item("100", "some item", ItemType.SERVER);
    when(itemService.retrieveItem("100", ItemType.SERVER)).thenReturn(someItem);
    when(mockedProvisioningBackend.forwardItem(someItem, requestDto)).thenReturn(false);
    ResponseDto responseDto = lockingDelimiterService.processRequest(requestDto);
    assertEquals(Status.NO_PROCESSED, responseDto.getStatus());
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