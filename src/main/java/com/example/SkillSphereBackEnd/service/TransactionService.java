package com.example.SkillSphereBackEnd.service;

import com.example.SkillSphereBackEnd.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {
    List<TransactionDTO> getAllTransactions(); // Get all transactions
    TransactionDTO getTransactionById(Long transactionId); // Get a specific transaction by ID
    List<TransactionDTO> getTransactionsByStudent(Long studentId); // Get transactions by student ID
    List<TransactionDTO> getTransactionsByCourse(Long courseId); // Get transactions by course ID
    TransactionDTO createTransaction(TransactionDTO transactionDTO); // Create a new transaction
}
