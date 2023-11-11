package model.services;

public interface class onlinePaymentService {
	
	double paymentFee(double amount);
	double interest(double amount, Integer months);
	
}
