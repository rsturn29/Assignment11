package com.codercampus.Assignment11.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionsController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/transactions")
		public String getTransactionHistory(ModelMap model) {
		List<Transaction> fundsMovement = transactionService.findAll();

		model.put("transaction", fundsMovement);

	
				return "transactions";
	
}
	@GetMapping("/transactions/{transactId}")
		public String getTransactionById(ModelMap model,@PathVariable Long transactId ) {
		Transaction transact = transactionService.findById(transactId);
		model.put("transaction", transact);
			return "transaction";
		
	}
}
