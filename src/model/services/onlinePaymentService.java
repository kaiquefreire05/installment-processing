package model.services;

public interface onlinePaymentService {
	
	double paymentFee(double amount);
	double interest(double amount, Integer months);
	
}
