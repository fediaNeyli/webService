package tn.iit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.iit.spring.dao.MotDao;
import tn.iit.spring.entities.Langue;
import tn.iit.spring.entities.Mot;

@Controller
@RequestMapping("api/mot")
public class MotController {
	@Autowired
	private MotDao dao;

	@GetMapping
	@ResponseBody
	public List<Mot> list() {
		return dao.findAll();

	}

	@PutMapping
	public void add(@RequestBody Mot mot) {
		dao.save(mot);
	}

	@DeleteMapping("/{id}")
	public void delate(@PathVariable Long id) {
		dao.delete(id);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Mot show(@PathVariable Long id) {
		return dao.findOne(id);
	}

	@PutMapping("/{id}") // lazemni ndéfini chkoun elli bch nmodifih
	public void edit(@PathVariable Long id, @RequestBody Mot mot) {
		Mot motdb = dao.findOne(id);
		if (motdb == null) {
			throw new RuntimeException("langue not found");
		}
		if (mot.getValeur() != null) {
			motdb.setValeur(mot.getValeur());
		}

		dao.save(motdb);
	}

}
