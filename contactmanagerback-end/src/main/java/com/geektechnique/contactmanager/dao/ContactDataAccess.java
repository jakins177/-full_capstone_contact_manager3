package com.geektechnique.contactmanager.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.geektechnique.contactmanager.model.ContactManagerDB;
import com.geektechnique.contactmanager.model.Contact;

@Repository("contactManagerPsqlcontact")
public class ContactDataAccess implements ContactDao {
	
ContactManagerDB realDB = new ContactManagerDB();
	
    @Override
    public int insertContact(Contact contact) {
        realDB.createContactRecord(contact.getOwnerEmail(), contact.getContactName(), contact.getContactEmail());
        return 0;
    }
    
    @Override
    public List<Contact> selectAllContactsForUser(String User) {
		 
		 return realDB.getAllContactsForUser(User);
	 }

}
