package pe.edu.vg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vg.app.model.Person;
import pe.edu.vg.app.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person updatedPerson) {
        if (personRepository.existsById(id)) {
            updatedPerson.setPersonID(id);
            return personRepository.save(updatedPerson);
        } else {
            return null; // or throw an exception
        }
    }

    public boolean deletePerson(Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
