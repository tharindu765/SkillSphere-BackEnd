package com.example.SkillSphereBackEnd.controller;

import com.example.SkillSphereBackEnd.dto.TransactionDTO;
import com.example.SkillSphereBackEnd.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Get all transactions
    @GetMapping
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        List<TransactionDTO> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    // Get a specific transaction by ID
    @GetMapping("/{transactionId}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long transactionId) {
        TransactionDTO transaction = transactionService.getTransactionById(transactionId);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    // Get transactions by student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByStudent(@PathVariable Long studentId) {
        List<TransactionDTO> transactions = transactionService.getTransactionsByStudent(studentId);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    // Get transactions by course ID
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByCourse(@PathVariable Long courseId) {
        List<TransactionDTO> transactions = transactionService.getTransactionsByCourse(courseId);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    // Create a new transaction
    @PostMapping
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionDTO transactionDTO) {
        TransactionDTO createdTransaction = transactionService.createTransaction(transactionDTO);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }
}
