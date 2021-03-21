
package com.emu.comunda.service.dto.camundadtos;
/**
 * Copyright 2021-2022 By Dirac Systems.
 *
 * Created by khalid.nouh on 17/3/2021.
 */

public class ProcessDefinitionDto {
    private String key ;
    private String revision ;
    private String version ;
    private String category ;
    private String deploymentId ;
    private String resourceName  ;
    private String historyLevel  ;
    private String startFormHandler ;
    private String diagramResourceName ;
    private boolean isGraphicalNotationDefined ;
    private String taskDefinitions ;
    private String hasStartFormKey ;
    private String suspensionState ;

    @Override
    public String toString() {
        return "ProcessDefinitionDto{" +
            "key='" + key + '\'' +
            ", revision='" + revision + '\'' +
            ", version='" + version + '\'' +
            ", category='" + category + '\'' +
            ", deploymentId='" + deploymentId + '\'' +
            ", resourceName='" + resourceName + '\'' +
            ", historyLevel='" + historyLevel + '\'' +
            ", startFormHandler='" + startFormHandler + '\'' +
            ", diagramResourceName='" + diagramResourceName + '\'' +
            ", isGraphicalNotationDefined=" + isGraphicalNotationDefined +
            ", taskDefinitions='" + taskDefinitions + '\'' +
            ", hasStartFormKey='" + hasStartFormKey + '\'' +
            ", suspensionState='" + suspensionState + '\'' +
            '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getHistoryLevel() {
        return historyLevel;
    }

    public void setHistoryLevel(String historyLevel) {
        this.historyLevel = historyLevel;
    }

    public String getStartFormHandler() {
        return startFormHandler;
    }

    public void setStartFormHandler(String startFormHandler) {
        this.startFormHandler = startFormHandler;
    }

    public String getDiagramResourceName() {
        return diagramResourceName;
    }

    public void setDiagramResourceName(String diagramResourceName) {
        this.diagramResourceName = diagramResourceName;
    }

    public boolean isGraphicalNotationDefined() {
        return isGraphicalNotationDefined;
    }

    public void setGraphicalNotationDefined(boolean graphicalNotationDefined) {
        isGraphicalNotationDefined = graphicalNotationDefined;
    }

    public String getTaskDefinitions() {
        return taskDefinitions;
    }

    public void setTaskDefinitions(String taskDefinitions) {
        this.taskDefinitions = taskDefinitions;
    }

    public String getHasStartFormKey() {
        return hasStartFormKey;
    }

    public void setHasStartFormKey(String hasStartFormKey) {
        this.hasStartFormKey = hasStartFormKey;
    }

    public String getSuspensionState() {
        return suspensionState;
    }

    public void setSuspensionState(String suspensionState) {
        this.suspensionState = suspensionState;
    }
    /* tenantId = null
    versionTag = null
    historyTimeToLive = null
    isIdentityLinksInitialized = false
    definitionIdentityLinkEntities = {ArrayList@27739}  size = 0
    candidateStarterUserIdExpressions = {HashSet@27740}  size = 0
    candidateStarterGroupIdExpressions = {HashSet@27741}  size = 0
    isStartableInTasklist = true
    firstVersion = true
    previousProcessDefinitionId = null
    name = null
    description = null
    initial = null
    initialActivityStacks = {HashMap@27742}  size = 0
    laneSets = null
    participantProcess = null
    isSubProcessScope = true
    flowActivities = {
        ArrayList @27743}  size = 0
    namedFlowActivities = {HashMap@27744}  size = 0
    eventActivities = {HashSet@27745}  size = 0
    processDefinition = {
        ProcessDefinitionEntity @22826} "ProcessDefinitionEntity[firstdeploy:1:72a2111f-8663-11eb-8479-a0d3c10c57bb]"
    BACKLOG = {HashMap@27746}  size = 0
    ioMapping = null
    id = "firstdeploy:1:72a2111f-8663-11eb-8479-a0d3c10c57bb"
    CoreModelElement.name = null
    properties = {Properties@27748} "Properties [properties={documentation=null}]"
    builtInListeners = {HashMap@27749}  size = 0
    listeners = {HashMap@27750}  size = 0
    builtInVariableListeners = {HashMap@27751}  size = 0
    variableListeners = {HashMap@27752}  size = 0*/
}
