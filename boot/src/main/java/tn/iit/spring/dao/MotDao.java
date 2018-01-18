package tn.iit.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.spring.entities.Mot;

@Repository
public interface MotDao extends JpaRepository<Mot, Long> {

}
