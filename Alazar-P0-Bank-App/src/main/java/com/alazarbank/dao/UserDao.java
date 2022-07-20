package com.alazarbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;
import com.alazarbank.models.User;

public class UserDao {
	String url = "jdbc:postgresql://database-alazarfh.czbgqw6mbp2i.us-east-1.rds.amazonaws.com:5432/postgres";
	String role = "postgresalazar";
	String pw = "password";
	private static Connection conn;

	public void connect() {
		try{
			conn = DriverManager.getConnection(url,role,pw);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public User insertUser(User user) {
			connect();
		
			String query = "INSERT INTO user_table (first_name, last_name, email, pw_hash) " +
					"VALUES (?, ?, ?, ?) RETURNING id";
			
			try {
				PreparedStatement s = conn.prepareStatement(query);
		
				s.setString(1, user.getFirstName());
				s.setString(2, user.getLastName());
				s.setString(3, user.getEmail());
				s.setString(4, user.getPass_hash());
				ResultSet resultSet = s.executeQuery();

				if (resultSet.next()) {
					user.setId(resultSet.getInt("id"));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return user;
	}
	
	public boolean getUserAccounts(User user, boolean hasAccts) {
		connect();
		
		String query = "SELECT * FROM account_table WHERE id = ANY (SELECT accounts_id" 
						+ "	FROM users_accounts WHERE users_id = ?)";
		
		try {
			PreparedStatement s = conn.prepareStatement(query);
		
			s.setInt(1, user.getId());
			ResultSet resultSet = s.executeQuery();
			
			while (resultSet.next()) {
				int a = resultSet.getInt("id");
				String b = resultSet.getString("acct_type");
				double d = resultSet.getDouble("balence");
				System.out.println("              " + a + " | " + b + ":    " + d + " ");
				
				user.getAcctNumbers().add(a);
				hasAccts = true;
			}
			
			resultSet.close();
			s.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		user.setAcctNumbers(user.getAcctNumbers());
		return hasAccts;
	}
	
	
	public User checkUser(User user, String email, String pwLogin) {
		connect();
				
		try {
			PreparedStatement s = conn.prepareStatement("SELECT id, first_name, last_name, pw_hash FROM user_table WHERE email = ?");
			s.setString(1, email);
			ResultSet resultSet = s.executeQuery();
			boolean emailFound = false;
			
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String first_name = resultSet.getString(2);
				String last_name = resultSet.getString(3);
				String password = resultSet.getString(4);
				emailFound = true;
				
				if(BCrypt.checkpw(pwLogin, password)){
					user.setId(id);
					user.setFirstName(first_name);
					user.setLastName(last_name);
					user.setEmail(email);
					user.setPass_hash(pwLogin);
				}else {
					System.out.println("         Wrong password. Please, try again.");
					System.exit(0);
				}
			}
			
			resultSet.close();
			s.close();
			
			if(emailFound == false) {
				System.out.println("         Email doesn't exist");
				System.exit(0);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}