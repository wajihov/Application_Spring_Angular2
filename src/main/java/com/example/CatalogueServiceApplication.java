package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;

import com.example.dao.ProduitRepository;
import com.example.entities.Produit;

@SpringBootApplication
public class CatalogueServiceApplication implements CommandLineRunner {

	@Autowired
	private ProduitRepository produitRepository;
	
	public static void main(String[] args)  {
		SpringApplication.run(CatalogueServiceApplication.class, args);
		/*ApplicationContext ctx= SpringApplication.run(CatalogueServiceApplication.class, args);
		ProduitRepository produitRepository=(ProduitRepository) ctx.getBean(ProduitRepository.class);
		produitRepository.save(new Produit("AAA", 1500, 150));
		produitRepository.save(new Produit("BBB", 7800, 120));
		produitRepository.save(new Produit("CCC", 9500, 100));
		List <Produit> produits=produitRepository.findAll();
		produits.forEach(p->System.out.println(p.getDesignation()));*/
		
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		//ProduitRepository produitRepository=(ProduitRepository) ctx.getBean(ProduitRepository.class);
		/*produitRepository.save(new Produit("GGG", 9500, 60));
		produitRepository.save(new Produit("KLOM", 6200, 80));
		produitRepository.save(new Produit("PLMO", 700, 90));
		produitRepository.save(new Produit("AAA", 1500, 150));
		produitRepository.save(new Produit("BBB", 7800, 120));
		produitRepository.save(new Produit("CCC", 9500, 100));*/
		List <Produit> produits=produitRepository.findAll();
		produits.forEach(p->System.out.println(p.getDesignation()));
		
	}
}
