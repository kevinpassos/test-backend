package br.com.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import br.com.test.database.dao.CustomerAccountDao;
import br.com.test.database.entity.CustomerAccount;

public class Main {

	private static final int N = 3000;

	private static final float TOTAL_VALUE_MIN = 200.0F;
	private static final float TOTAL_VALUE_MAX = 3000.0F;

	private static final Random RAND = new Random();

	public static void main(String[] args) throws Exception {
		CustomerAccountDao dao = new CustomerAccountDao();

		for (int i = 0; i < N; i++) {
			CustomerAccount customerAccount = new CustomerAccount();
			customerAccount.setId(i);
			customerAccount.setCpfCnpj("Cpf " + i);
			customerAccount.setName("Nome " + i);
			customerAccount.setActive((i % 2 == 0) ? true : false);
			customerAccount.setTotalValue(RAND.nextFloat() * (TOTAL_VALUE_MAX - TOTAL_VALUE_MIN) + TOTAL_VALUE_MIN);

			System.out.println("Inserindo customerAccount com id " + i);
			dao.insert(customerAccount);
		}
		
		// Pega todos os dados inseridos na tabela tb_customer_account
		System.out.println("Obtendo todos os customerAccounts inseridos no banco de dados");
		List<CustomerAccount> customerAccountList = dao.findAll();
		
		List<CustomerAccount> usedCustomerAccounts = new ArrayList<>();
		float sum = 0.0F;
		
		for (CustomerAccount customerAccount : customerAccountList) {
			if (customerAccount.getTotalValue() > 560.0F && (customerAccount.getId() >= 1500 && customerAccount.getId() <= 2700)) {
				usedCustomerAccounts.add(customerAccount);
				sum += customerAccount.getTotalValue();
			}
		}
		
		System.out.println("Média final: " + sum / usedCustomerAccounts.size());
		
		Collections.sort(usedCustomerAccounts, new Comparator<CustomerAccount>() {
			@Override
			public int compare(CustomerAccount acc1, CustomerAccount acc2) {
				return acc1.getTotalValue().compareTo(acc2.getTotalValue());
			}
		});
		
		for (CustomerAccount customerAccount : usedCustomerAccounts) {
			System.out.println(customerAccount.getName() + " - valor total: " + customerAccount.getTotalValue());
		}
	}

}
