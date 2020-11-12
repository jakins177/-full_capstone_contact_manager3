package com.geektechnique.contactmanager.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geektechnique.contactmanager.model.Contact;
import com.geektechnique.contactmanager.service.ContactService;

@RequestMapping("contactmanagerapi/v1/contact")
@RestController
public class ContactController {
	private final ContactService contactService;

	 @Autowired
	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}
	 
	 @CrossOrigin
	 @PostMapping
	    public int addUser(@Valid @NonNull @RequestBody Contact contact){
	       return contactService.addContact(contact);
	    }

	 @CrossOrigin
	 @GetMapping(path = "{user}")
public List<Contact> selectAllContactsForUser(@PathVariable("user")String User) {
		 
		 return contactService.getAllContactsForUser(User);
	 }

}
