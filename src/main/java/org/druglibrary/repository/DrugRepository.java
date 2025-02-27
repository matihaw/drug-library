package org.druglibrary.repository;

import org.druglibrary.entity.Drug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DrugRepository extends CrudRepository<Drug, Long> {
}
