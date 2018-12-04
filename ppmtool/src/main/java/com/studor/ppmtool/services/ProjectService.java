package com.studor.ppmtool.services;

import com.studor.ppmtool.domain.Project;
import com.studor.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        //add further logic for update and user
        return projectRepository.save(project);
    }

}
