package com.geektechnique.contactmanager.dao;

import java.util.List;

import com.geektechnique.contactmanager.model.Contact;

public interface ContactDao {
int insertContact(Contact contact);

List<Contact> selectAllContactsForUser(String User);

}
