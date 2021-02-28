package com.codercampus.Assignment11.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

// Controller -> Service -> Repository!!

@Controller
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping ("")
	public String homePage() {
		return "homePage";
	}
	
	@GetMapping("/transactions")
	public String getAllTransactionsByDate(ModelMap model) {
		List<Transaction> allTransactions = transactionService.getAllTransactionsByDate();
		model.put("transactions", allTransactions);

		return "allTransactions";
	}

	@GetMapping("transaction/{transactionId}")
	public String getTransactionsById(ModelMap model, @PathVariable Long transactionId) {
		Transaction transactionById = transactionService.getTransactionById(transactionId);
		model.put("transactionById", transactionById);

		return "transactionById";
	}

}