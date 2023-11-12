package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	// construtor

	public ContractService(OnlinePaymentService onlinePaymentService) { 
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {
		
		// basicQuota = valor base de cada parcela
		double basicQuota = contract.getTotalValue() / months;
		
		for(int i=0;i <= months;i++) {
			// Adicionando um mês a data original do contrato
			LocalDate dueDate = contract.getDate().plusMonths(i);
			
			double interest = onlinePaymentService.interest(basicQuota, i);
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);
			double quota = basicQuota + interest + fee;
			
			contract.getInstallments().add(new Installment(dueDate, quota));
			
		}
		
		
	}

}
