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

import tn.iit.spring.dao.LangueDao;
import tn.iit.spring.entities.Langue;

@Controller
@RequestMapping("api/langue")
public class LangueController {

	@Autowired
	private LangueDao langueDao;

	@GetMapping
	@ResponseBody
	public List<Langue> list() {
		return langueDao.findAll();

	}

	@DeleteMapping("/{id}")
	public void delate(@PathVariable Long id) {
		langueDao.delete(id);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Langue show(@PathVariable Long id) {
		return langueDao.findOne(id);
	}

	/*
	 * @GetMapping("/{nom}")
	 * 
	 * @ResponseBody public Langue findByNom(@PathVariable String nom) { return
	 * langueDao.findByNom(nom); }
	 */

	@PutMapping
	public void add(@RequestBody Langue langue) {
		langueDao.save(langue);
	}

	@PutMapping("/{id}") // lazemni ndéfini chkoun elli bch nmodifih
	public void edit(@PathVariable Long id, @RequestBody Langue langue) {
		Langue langueDB = langueDao.findOne(id);
		if (langueDB == null) {
			throw new RuntimeException("langue not found");
		}
		if (langue.getNom() != null) {
			langueDB.setNom(langue.getNom());
		}
		if (langue.getAbreviation() != null) {
			langueDB.setAbreviation(langue.getAbreviation());
		}

		langueDao.save(langueDB);
	}

}
