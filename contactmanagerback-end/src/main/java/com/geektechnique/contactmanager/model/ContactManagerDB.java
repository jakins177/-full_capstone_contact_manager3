package com.geektechnique.contactmanager.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.geektechnique.contactmanager.model.Contact;

public class ContactManagerDB {
	String url;
	String user;
	String password;
	
	public ContactManagerDB() {
		super();
		this.url = "jdbc:postgresql://localhost:5432/contactmanagerDB";
		this.user = "postgres";
		this.password = "admin";
		
	}
	
	
	 public List<Contact> getAllContactsForUser(String user)
	{
			List<Contact> userList = new ArrayList<>();
			Connection c = null;

			   Statement stmt = null;

			   try {

			      Class.forName("org.postgresql.Driver");

			      c = DriverManager.getConnection(this.url,this.user, this.password);

//			     c.setAutoCommit(false);

			      System.out.println("Successfully Connected.");



			      stmt = c.createStatement();

			      ResultSet rs = stmt.executeQuery( "SELECT * from contacts WHERE owner_user_name = '" + user + "';" );

			      while ( rs.next() ) {

			         String  ownerEmail = rs.getString("owner_user_name");
			         String  contactName = rs.getString("contact_name");
			         String  contactEmail = rs.getString("contact_email");
			         
			        userList.add(new Contact(ownerEmail, contactName, contactEmail ));

			        
			      }

			      rs.close();

			      stmt.close();

			      c.close();

			   } catch ( Exception e ) {

			      System.err.println( e.getClass().getName()+": "+ e.getMessage() );

			      System.exit(0);

			   }

			   System.out.println(" Data Retrieved Successfully ..");

			
			return userList;
	}
	
	public int createContactRecord(String ownerEmail, String contactName, String contactEmail) {   
	     
        String query = "INSERT INTO contacts(owner_user_name, contact_name, contact_email) VALUES(?,?,?)";

        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
             PreparedStatement pst = con.prepareStatement(query)) {
            
 
            pst.setString(1, ownerEmail);
            pst.setString(2, contactName);
            pst.setString(3, contactEmail); 
            pst.executeUpdate();

          //  System.out.println("password is: " + password + "email is: " + email  );
            return 1;
            
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            return 0;
        }
		
		
		
		

	}
	
	public int createUserRecord(String email, String password) {   
     
        String query = "INSERT INTO users(email, password) VALUES(?,?)";

        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
             PreparedStatement pst = con.prepareStatement(query)) {
            
 
            pst.setString(1, email);
            pst.setString(2, password); 
            pst.executeUpdate();

            System.out.println("password is: " + password + "email is: " + email  );
            return 1;
            
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            return 0;
        }
		
		
		
		

	}
	
	public int checkForDupes(String userNameToCheck)
	{
		
		List<User> userList = new ArrayList<>();
		Connection c = null;

		   Statement stmt = null;

		   try {

		      Class.forName("org.postgresql.Driver");

		      c = DriverManager.getConnection(this.url,this.user, this.password);

//		     c.setAutoCommit(false);

		      System.out.println("Successfully Connected.");



		      stmt = c.createStatement();

		      ResultSet rs = stmt.executeQuery( "SELECT * from users WHERE email = '" + userNameToCheck + "';" );

		      while ( rs.next() ) {

		        

		       return 1;

		        
		      }

		      rs.close();

		      stmt.close();

		      c.close();

		   } catch ( Exception e ) {

		      System.err.println( e.getClass().getName()+": "+ e.getMessage() );

		      System.exit(0);

		   }

		   System.out.println(" Data Retrieved Successfully ..");


		   return 0;

	}




}
