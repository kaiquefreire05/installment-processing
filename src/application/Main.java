package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados do contrato: ");
		System.out.print("Número: ");
		int number = sc.nextInt();
		System.out.print("Data(dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt); // lendo a data no formato fmt
		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		
		Contract obj = new Contract(number, date, totalValue);
		
		System.out.print("Entre com o número de parcelas: ");
		int n = sc.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(obj, n);
		
		System.out.println("PARCELAS:");
		for (Installment installment : obj.getInstallments())
			System.out.println(installment);
		
		
		sc.close();
	}

}
