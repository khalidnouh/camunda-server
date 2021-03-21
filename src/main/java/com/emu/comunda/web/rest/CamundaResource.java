package com.emu.comunda.web.rest;

import com.emu.comunda.feign.ProxyFeign;
import com.emu.comunda.service.dto.camundadtos.DeploymentDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.repository.DeploymentBuilder;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Copyright 2021-2022 By Dirac Systems.
 * <p>
 * Created by khalid.nouh on 17/3/2021.
 */
@Log4j2
@RestController
@RequestMapping("/api")
public class CamundaResource {
    @Autowired
    ProcessEngine processEngine;
    @Autowired
    ProxyFeign proxyFeign;

    @GetMapping("/get")
    public String get() {
        return proxyFeign.get();
    }

    /**
     * Post Deployment,Create a deployment.
     * POST /deployment/create
     */
    @ApiOperation(value = "Create a deployment in Camunda server")
    /*Optional below comments*/
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Request successful.")}
    )
    @PostMapping(path = "/createDeployment/{deploymentName}", consumes = "multipart/form-data")
    public DeploymentDto createDeployment(@PathVariable("deploymentName") String deploymentName, @RequestParam("file") MultipartFile multipartFile) throws IOException {
//        log.info(String.format("Create Deployment with deploymentName %s,with file name %s",deploymentName,multipartFile.getOriginalFilename()));
        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment().name(deploymentName);
        deploymentBuilder.addInputStream(multipartFile.getOriginalFilename(), multipartFile.getInputStream());
        Deployment deployment = deploymentBuilder.deploy();
        DeploymentDto deploymentDto = new DeploymentDto();
        if (deployment.getId() != null && !deployment.getId().equals("")) {
//            log.info(String.format("Deployment Creation Succeded with deploymentId %s",deployment.getId()));
            deploymentDto.setId(deployment.getId());
            deploymentDto.setName(deployment.getName());
            deploymentDto.setDeploymentTime(deployment.getDeploymentTime().toString());
            System.out.println("deployment: " + deployment);
            return deploymentDto;
        } else {
//            log.info(String.format("Deployment creation faild with deployment name  %s",deploymentName));
            return null;

        }

    }

    @PostMapping("/startProcessInstanceByKey/{deploymentName}")
    public String startProcess(@PathVariable("deploymentName") String deploymentName) {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(deploymentName);
        return "started";
    }

    @ApiOperation(value = "Get All process-definitions")
    /*Optional below comments*/
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Request successful."),
        @ApiResponse(code = 400, message = "Returned if some of the query parameters are invalid, for example if a sortOrder parameter is supplied, but no sortBy. See the Introduction for the error response format.")}
    )
    @GetMapping("/process-definition")
    public String processDefinitions() {
//        log.info(String.format("Get All process-definitions"));
        RepositoryService repositoryService = processEngine.getRepositoryService();
        List<ProcessDefinition> myProcessDefinition =
            repositoryService.createProcessDefinitionQuery().list();
        return myProcessDefinition.toString();
    }

    /**
     * {@code GET  /taskById/{taskId}} : get taskById.
     *
     * @return
     */
    @ApiOperation(value = "Get task by id")
    /*Optional below comments*/
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/taskById/{taskId}")
    public String getTaskById(@PathVariable("taskId") String taskId) {
//        log.info(String.format("Get task by id:"+taskId));

        RuntimeService runtimeService = processEngine.getRuntimeService();
//String result=processEngine.getManagementService().createJobQuery().executionId("1:6e1551a8-8662-11eb-99c2-a0d3c10c57bb").singleResult().getId();
//        String result=processEngine.getTaskService().createTaskQuery().processInstanceId("1:6e1551a8-8662-11eb-99c2-a0d3c10c57bb").list().size()+"";
        String ulr = "http://localhost:8087/engine-rest/deployment/";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(ulr, String.class);
        return result;
    }


    /**
     * Starting a process instance at its default initial activity:
     * * start Process By Process Definition Id
     */
    @ApiOperation(value = "Start Process By Process Definition Id")
    /*Optional below comments*/
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Request successful."),
        @ApiResponse(code = 400, message = "The instance could not be created due to an invalid variable value, for example if the value could not be parsed to an Integer value or the passed variable type is not supported. See the Introduction for the error response format"),
        @ApiResponse(code = 404, message = "The instance could not be created due to a non existing process definition key. See the Introduction for the error response format"),
        @ApiResponse(code = 500, message = "The instance could not be created successfully. See the Introduction for the error response format.")
    }
    )
    @PostMapping("/startProcessByProcessDefinitionId/{processDefinitionId}")
    public String startProcessByProcessDefinitionId(@PathVariable("processDefinitionId") String processDefinitionId) {
        return null;
    }


    /**
     * Starting a process instance at its default initial activity:
     * * start Process By Process Definition key
     */
    @ApiOperation(value = "Start Process By Process Definition key")
    /*Optional below comments*/
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Request successful."),
        @ApiResponse(code = 400, message = "The instance could not be created due to an invalid variable value, for example if the value could not be parsed to an Integer value or the passed variable type is not supported. See the Introduction for the error response format."),
        @ApiResponse(code = 404, message = "The instance could not be created due to a non existing process definition key. See the Introduction for the error response format."),
        @ApiResponse(code = 500, message = "The instance could not be created successfully. See the Introduction for the error response format.")
    }
    )
    @PostMapping("/startProcessByProcessDefinitionKey/{processDefinitionKey}")
    public String startProcessByProcessDefinitionKey(@PathVariable("processDefinitionKey") String processDefinitionKey) {

        return null;
    }

    /**
     * Correlates a message to the process engine to either trigger
     * a message start event or an intermediate message catching event
     */
    @ApiOperation(value = "Correlates a message to the process engine")
    /*Optional below comments*/
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Request successful. The property resultEnabled in the request body was true."),
        @ApiResponse(code = 204, message = "Request successful. The property resultEnabled in the request body was false (Default)."),
        @ApiResponse(code = 400, message = "If no messageName was supplied. If both tenantId and withoutTenantId are supplied." +
            "If the message has not been correlated to exactly one entity (execution or process definition), or the variable value or type is invalid, for example if the value could not be parsed to an Integer value or the passed variable type is not supported. See the Introduction for the error response format.")
    }
    )
    @PostMapping("/sendMessage")
    public String sendMessage() {

        return null;
    }

}
