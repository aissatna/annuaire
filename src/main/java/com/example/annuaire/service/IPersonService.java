package com.example.annuaire.service;

import com.example.annuaire.model.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonService {
     List<Person> getAllPersons();
     Optional<Person> getFromId(Long personId);
     void deleteFromId(Long personId);
     void addPerson(Person person);
     Boolean existPerson (Long personId);
     Boolean existPersonByPhone (String phone);
     void updatePerson (Long personId,String name,String surname, String phone,String city);

}
