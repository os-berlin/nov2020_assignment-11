package com.codercampus.Assignment11.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepo;
	

	
	public List<Transaction> getAllTransactionsByDate() {
		
		List<Transaction> transactionsByDate = transactionRepo.findAll();
		
		Collections.sort(transactionsByDate, new Comparator<Transaction>() {
		    @Override
		    public int compare(Transaction t1, Transaction t2) {
		        return t1.getDate().compareTo(t2.getDate());
		    }
		});
		
		return transactionsByDate;
	}

	public Transaction getTransactionById(long transactionId) {
		
		Optional<Transaction> transactionById = transactionRepo.findAll().stream()
														   				 .filter(transaction -> transaction.getId().equals(transactionId))
														   				 .findFirst();
		return transactionById.orElse(null);
	}

}
