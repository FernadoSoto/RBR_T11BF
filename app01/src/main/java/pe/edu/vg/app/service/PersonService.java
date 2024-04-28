package pe.edu.vg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vg.app.model.Person;
import pe.edu.vg.app.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person personDetails) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found with id " + id));

        person.setName(personDetails.getName());
        person.setLastName(personDetails.getLastName());
        person.setDocumentType(personDetails.getDocumentType());
        person.setDocumentNumber(personDetails.getDocumentNumber());
        person.setPhone(personDetails.getPhone());
        person.setStatus(personDetails.getStatus());
        person.setRole(personDetails.getRole());

        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
