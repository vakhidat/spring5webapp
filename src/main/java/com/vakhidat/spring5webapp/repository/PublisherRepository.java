package com.vakhidat.spring5webapp.repository;

import com.vakhidat.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
