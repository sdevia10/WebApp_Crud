package com.cestar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cestar.model.Client;
//import com.cestar.model.Employee;


public class EmpDao {

	// Our Method returns a Connection Object

	public Connection getConnection() {

		Connection con = null;

		// Write the Connection parameters

		String url = "jdbc:mysql://localhost:3306/shippingrecords";

		String user = "root";

		String pwd = "";

		// Register the Driver

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pwd);

			System.out.println("Connection Successfull");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

	// Displaying Records From Database Table
	
	

	// NEW CODE
	public List<Client> read(){
		
		List<Client> clients = new ArrayList<>();
		
		String sql = "select * from clients";
		Connection con = getConnection();
		
		try {

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Client client_from_resultset = new Client(rs.getInt("id"), rs.getString("name"),
						rs.getString("contact"), rs.getString("itemShipped"), rs.getDate("date_Received"),rs.getDate("date_Shipped"));

				clients.add(client_from_resultset);
			}

			System.out.println(clients);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clients;
	}
	
	// INSERT RECORD
	
	public int insert(Client client_to_be_inserted) {
		
		int status = 0 ;

		String sql = "insert into clients (id,name,contact,itemShipped,date_Received,date_Shipped) values (? , ? ,? ,? ,?,?)";

		// set up the connection

		Connection con = getConnection();

		// For Insert Query with ? marks we always use PreparedStatement

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);

			// Now we have to set the values for these question marks

			pstmt.setInt(1, client_to_be_inserted.getId());

			pstmt.setString(2, client_to_be_inserted.getName());

			pstmt.setString(3, client_to_be_inserted.getContact());

			pstmt.setString(4, client_to_be_inserted.getItemShipped());

			pstmt.setDate(5, client_to_be_inserted.getDate_received());
			
			pstmt.setDate(6,client_to_be_inserted.getDate_shipped() );

			// After setting all values for ? marks we have to use executeUpdate Method

			 status = pstmt.executeUpdate();

			if (status > 0) {

				System.out.println("Record Added Successfullly congratulations!!!");

				read();
			} else {
				System.out.println("Some Error Occured Try Again Please!!!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

	}
	
	public Client getRecById(int id_to_getRecord) {
		
		Client client = null ;
		
		Connection con = getConnection();
		
		String sql = "select * from clients where id = ?";
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id_to_getRecord);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				client = new Client(rs.getInt("id"),rs.getString(2),rs.getString("contact"),rs.getString("itemShipped"),rs.getDate("date_Received"),rs.getDate("date_Shipped"));
			}
			
		   System.out.println(client);
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return client;
		
	}
	
	
	public void updateById(int curr_id ,Client upd_client) {
		
		Connection con = getConnection();
		
		String sql = "update clients set id=? ,name=? ,contact=?,itemShipped=?,date_Received=?,date_Shipped=? where id= ?";
		
	    try {
			
	    	PreparedStatement pstmt = con.prepareStatement(sql);
	    	
	    	pstmt.setInt(1,upd_client.getId() );
		
	    	pstmt.setString(2, upd_client.getName());
	    	
	    	pstmt.setString(3, upd_client.getContact());
	    	
	    	pstmt.setString(4, upd_client.getItemShipped());
	    	
	    	pstmt.setDate(5, upd_client.getDate_received());
	    	
	    	pstmt.setDate(6,upd_client.getDate_shipped() );
	    
	        pstmt.setInt(7, curr_id);
	        
	        int status = pstmt.executeUpdate();
	        
	        if(status>0) {
	        	
	        	System.out.println("Record Updated Successfully/Update Ho gia hai");
	        	read();
	        }
	        else {
	        	System.out.println("Try Again Please ,there is an error!!!");
	        }
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	public void delete(int id_to_deleteRec) {
		
		Connection con = getConnection();
		
		String sql = "delete from clients where id = ?";
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id_to_deleteRec);
		
		   int status = pstmt.executeUpdate();
		
		   if(status>0) {
			   
			   System.out.println("Record Deleted Successfully");
			   read();
		   }
		   else {
			   System.out.println("Tray again please!!!");
		   }
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
