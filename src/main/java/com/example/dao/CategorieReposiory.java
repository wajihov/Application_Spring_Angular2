package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.entities.Categorie;

@RepositoryRestResource
public interface CategorieReposiory extends JpaRepository<Categorie, Long> {

}
