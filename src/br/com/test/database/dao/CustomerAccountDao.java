package br.com.test.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.test.database.ConnectionFactory;
import br.com.test.database.entity.CustomerAccount;

public class CustomerAccountDao {

	private final Connection connection = ConnectionFactory.getConnection();

	public void insert(CustomerAccount customerAccount) throws SQLException {
		String sql = "INSERT INTO tb_customer_account (id_customer, cpf_cnpj, nm_customer, is_active, vl_total) VALUES (?, ?, ?, ?, ?)";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setInt(1, customerAccount.getId());
		stmt.setString(2, customerAccount.getCpfCnpj());
		stmt.setString(3, customerAccount.getName());
		stmt.setBoolean(4, customerAccount.isActive());
		stmt.setFloat(5, customerAccount.getTotalValue());

		stmt.execute();
		stmt.close();
	}

	public List<CustomerAccount> findAll() throws SQLException {
		String sql = "SELECT * FROM tb_customer_account";

		ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

		List<CustomerAccount> customerAccountList = new ArrayList<>();
		
		while (resultSet.next()) {
			CustomerAccount customerAccount = new CustomerAccount();
			customerAccount.setId(resultSet.getInt("id_customer"));
			customerAccount.setCpfCnpj(resultSet.getString("cpf_cnpj"));
			customerAccount.setName(resultSet.getString("nm_customer"));
			customerAccount.setActive(resultSet.getBoolean("is_active"));
			customerAccount.setTotalValue(resultSet.getFloat("vl_total"));
			
			customerAccountList.add(customerAccount);
		}

		return customerAccountList;
	}

}
