package com.studor.ppmtool.web;

import com.studor.ppmtool.domain.Project;
import com.studor.ppmtool.services.MapValidationErrorService;
import com.studor.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult br){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(br);
        if(errorMap != null){return errorMap;}

        Project project1 = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<?> updateProject(@PathVariable String projectId){
        Project project = projectService.findProjectByIdentifier((projectId));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectId(@PathVariable String projectId){
        Project project = projectService.findProjectByIdentifier(projectId);

        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Project>getAllProjects(){ return projectService.findAllProjects();}

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable String projectId){
        projectService.deleteProjetByIdentifier(projectId);
        return new ResponseEntity<String>("Project with ID: "+ projectId +" has been deleted.", HttpStatus.OK);
    }
}
