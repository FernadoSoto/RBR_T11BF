package pe.edu.vg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.vg.app.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
