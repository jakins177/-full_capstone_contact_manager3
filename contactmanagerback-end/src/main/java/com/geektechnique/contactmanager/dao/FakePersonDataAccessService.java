package com.geektechnique.contactmanager.dao;

import org.springframework.stereotype.Repository;

import com.geektechnique.contactmanager.model.Person;
import com.geektechnique.contactmanager.model.PersonDataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")//referred to in PersonService
public class FakePersonDataAccessService implements PersonDao {

   
   
    PersonDataBase realDB = new PersonDataBase();
    
    
    @Override
    public int insertPerson(UUID id, Person person) {
        realDB.createPersonDocument(id, person.getName());
        return 0;
    }

    
    
    @Override
    public List<Person> selectAllPeople() {
        return realDB.getAllPersonDocuments();
    }
    

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return realDB.getPersonDocumentById(id);
    }
      
    
    @Override
    public int deletePersonById(UUID id) {

       realDB.deleteDocumentByID(id);
        return 1;
    }


    
    @Override
    public int updatePersonById(UUID id, Person update) {
        

     realDB.updateDocumentByID(id, update);
      return 1;
  }



}
