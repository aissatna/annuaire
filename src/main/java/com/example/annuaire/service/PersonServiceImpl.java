package com.example.annuaire.service;

import com.example.annuaire.model.Person;
import com.example.annuaire.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements IPersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> getFromId(Long personId) {
        return personRepository.findById(personId);

    }

    @Override
    public Boolean existPerson(Long personId) {
        return personRepository.existsById(personId);
    }

    @Override
    public void deleteFromId(Long personId) {
        personRepository.deleteById(personId);
    }

    @Override
    public void addPerson(Person person) {
        personRepository.save(person);

    }

    @Override
    public Boolean existPersonByPhone(String phone) {
        return personRepository.findByPhone(phone).isPresent();
    }

    @Transactional
    @Override
    public void updatePerson(Long personId, String name, String surname, String phone, String city) {

        Person person = personRepository.findById(personId).
                orElseThrow(() -> new IllegalStateException(
                        String.format("Person with id %s does not exist", personId)));
        if (name != null && name.length() > 0 && !person.getName().equals(name)) {
            person.setName(name);
        }
        if (surname != null && surname.length() > 0 && !person.getSurname().equals(surname)) {
            person.setSurname(surname);
        }
        if (phone != null && phone.length() > 0 && !person.getPhone().equals(phone)) {
            person.setPhone(phone);
        }
        if (city != null && city.length() > 0 && !person.getCity().equals(city)) {
            person.setCity(city);
        }

    }

}
