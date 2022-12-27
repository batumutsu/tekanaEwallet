package com.tekana.wallet.tekanaEwallet.controller;

import com.tekana.wallet.tekanaEwallet.model.Customer;
import com.tekana.wallet.tekanaEwallet.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Operation(summary = "Get Customers", description = "Get a list of all customers", tags = "Get")
    @ApiResponses(value =  {
            @ApiResponse(responseCode = "200", description = "Customers found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "404", description = "No customer found")
    })
    @GetMapping()
    public List<Customer> getAllClients() {
        return customerService.getAllCustomers();
    }

    @Operation(summary = "Get a customer", description = "Get details for customer", tags = "Get")
    @ApiResponses(value =  {
            @ApiResponse(responseCode = "200", description = "Customer details found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "404", description = "Customer details not found")
    })
    @GetMapping("{customerId}")
    public Customer getClientDetails(@PathVariable Long customerId) {
        return customerService.getCustomerDetails(customerId);
    }

    @Operation(summary = "Create a customer", description = "This endpoint will help us, to create a new customer", tags = "Post")
    @ApiResponses(value =  {
            @ApiResponse(responseCode = "200", description = "Customer created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "404", description = "Customer was not created")
    })
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @Operation(summary = "update customer details", description = "This endpoint will help us, to update a customer details", tags = "Put")
    @ApiResponses(value =  {
            @ApiResponse(responseCode = "200", description = "Customer updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "404", description = "Customer was not updated")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(customer);
        return ResponseEntity.ok(updatedCustomer);
    }
}

