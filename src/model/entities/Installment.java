package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment { // Installment == parcela
	
	private LocalDate dueDate;
	private Double amount;
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	// construtores
	
	public Installment(LocalDate dueDate, Double amount) {
		super();
		this.dueDate = dueDate;
		this.amount = amount;
	}
	
	// getters e setters
	
	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
		
	// toString
	
	@Override
	public String toString() {
		return dueDate.format(fmt) + " - " + String.format("%.2f", amount);
 	}

	
}
