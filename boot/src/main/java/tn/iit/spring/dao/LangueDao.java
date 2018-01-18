package tn.iit.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import tn.iit.spring.entities.Langue;

@RepositoryRestResource(path = "lang")
@Repository
public interface LangueDao extends JpaRepository<Langue, Long> {

	Langue findByNom(String nom);
	// Langue findByValueAndAbreviation(String nom, String abreviation);
}
