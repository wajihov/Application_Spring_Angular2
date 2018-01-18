package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ProduitRepository;
import com.example.entities.Produit;

@RestController
public class ProduitRestService {

	@Autowired
	private ProduitRepository produitRepository;

	@RequestMapping(value = "/produits", method = RequestMethod.GET)
	public List<Produit> ListProduit() {
		return produitRepository.findAll();
	}

	@RequestMapping(value = "/produitS", method = RequestMethod.GET)
	public Page<Produit> pageProduit(int page, int size) {
		return produitRepository.findAll(new PageRequest(page, size));
	}

	@RequestMapping(value = "/findProducts", method = RequestMethod.GET)
	public Page<Produit> chercher(String mc, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		return produitRepository.ChercherProduit("%" + mc + "%", new PageRequest(page, size));
	}

	@RequestMapping(value = "/produits/{id}", method = RequestMethod.GET)
	public Produit getProduit(@PathVariable("id") Long id) {
		return produitRepository.findOne(id);
	}

	@RequestMapping(value = "/produits", method = RequestMethod.POST)
	public Produit saveProduit(@RequestBody Produit produit) {
		return produitRepository.save(produit);
	}

	@RequestMapping(value = "/produits/{id}", method = RequestMethod.PUT)
	public Produit updateProduit(@RequestBody Produit produit, @PathVariable Long id) {
		produit.setIdProduit(id);
		return produitRepository.saveAndFlush(produit);
	}

	@RequestMapping(value = "/produits/{id}", method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable Long id) {
		produitRepository.delete(id);
	}

}