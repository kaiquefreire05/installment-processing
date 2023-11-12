package model.services;

public class PaypalService implements OnlinePaymentService{
	
	// variavel que só pode ser usada nesse objeto implementado
	private static final double FEE_PERCENTAGE = 0.02; // taxa por parcela
	private static final double MONTHLY_INTEREST = 0.01; // taxa mensal

	
	@Override
	public double paymentFee(double amount) {
		// TODO Auto-generated method stub
		return amount * FEE_PERCENTAGE;
	}

	@Override
	public double interest(double amount, int months) {
		// TODO Auto-generated method stub
		return amount * MONTHLY_INTEREST * months;
	}

}
