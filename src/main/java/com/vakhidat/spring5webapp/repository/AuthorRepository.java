package com.vakhidat.spring5webapp.repository;

import com.vakhidat.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
