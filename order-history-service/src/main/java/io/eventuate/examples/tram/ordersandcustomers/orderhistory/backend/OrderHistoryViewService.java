package io.eventuate.examples.tram.ordersandcustomers.orderhistory.backend;

import io.eventuate.examples.tram.ordersandcustomers.common.domain.Money;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

public class OrderHistoryViewService {

  private CustomerViewRepository customerViewRepository;

  public OrderHistoryViewService(CustomerViewRepository customerViewRepository) {
    this.customerViewRepository = customerViewRepository;
  }

  @Retryable(
          value = { DuplicateKeyException.class },
          maxAttempts = 4,
          backoff = @Backoff(delay = 250))
  public void createCustomer(Long customerId, String customerName, Money creditLimit) {
    customerViewRepository.addCustomer(customerId, customerName, creditLimit);
  }
}
