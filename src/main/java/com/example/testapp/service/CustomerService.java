package com.example.testapp.service;

import com.example.testapp.entity.Customer;
import com.example.testapp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    @Transactional
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Transactional
    public Customer update(Long id, Customer updated) {
        Customer existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public Page<Customer> getAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }
}