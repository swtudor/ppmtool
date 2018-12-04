package com.studor.ppmtool.repositories;

import com.studor.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long>{
    @Override
    Iterable<Project> findAllById(Iterable<Long> iterable);
}
