package io.eventuate.examples.tram.ordersandcustomers.orderhistory.backend;

import io.eventuate.examples.tram.ordersandcustomers.common.domain.Money;

public interface CustomerViewRepositoryCustom {

  void addCustomer(Long customerId, String customerName, Money creditLimit);

}
