package com.cbaeza.challenger.service;

import com.cbaeza.challenger.dataaccess_layer.ProvisioningBackend;
import com.cbaeza.challenger.dto.RequestDto;
import com.cbaeza.challenger.dto.ResponseDto;
import com.cbaeza.challenger.utils.ResponseUtils;

public class LockingDelimiterService {

  private final ProvisioningBackend provisioningBackend = new ProvisioningBackend();

  public LockingDelimiterService() {
  }

  public ResponseDto processRequest(RequestDto request) {
    // TODO do something with Provisioning backend
    return ResponseUtils.success(request, "200", "Success processed!");
  }
}
