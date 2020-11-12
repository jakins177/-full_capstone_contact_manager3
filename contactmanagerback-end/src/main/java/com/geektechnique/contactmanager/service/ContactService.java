package com.geektechnique.contactmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.geektechnique.contactmanager.dao.ContactDao;
import com.geektechnique.contactmanager.model.Contact;

@Service
public class ContactService {
	private final ContactDao contactDao;
	
	 @Autowired
	    public ContactService(@Qualifier("contactManagerPsqlcontact") ContactDao contactDao) {
	        this.contactDao = contactDao;
	    }
	 
	 public int addContact(Contact contact){
	        return contactDao.insertContact(contact);
	    }
	 
	 public List<Contact> getAllContactsForUser(String User) {
		 
		 return contactDao.selectAllContactsForUser(User);
	 }

}
