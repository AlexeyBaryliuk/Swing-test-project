package com.test.instance_of;

import java.time.LocalDate;

public class ProjectsDto {

    public ProjectsDto() {
    }

    public ProjectsDto(Integer projectId, String description, LocalDate dateAdded, Integer countOfDevelopers) {
        this.projectId = projectId;
        this.description = description;
        this.dateAdded = dateAdded;
        this.countOfDevelopers = countOfDevelopers;
    }

    /**
     * Project id.
     */
    private Integer projectId;

    /**
     * Project description.
     */
    private String description;

    /**
     * Date adding of project.
     */

    private LocalDate dateAdded;

    /**
     * Count of developers.
     */
    private Integer countOfDevelopers;

    public Integer getProjectId() {
        return projectId;
    }

    public ProjectsDto setProjectId(Integer projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProjectsDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public ProjectsDto setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
        return this;
    }

    public Integer getCountOfDevelopers() {
        return countOfDevelopers;
    }

    public ProjectsDto setCountOfDevelopers(Integer countOfDevelopers) {
        this.countOfDevelopers = countOfDevelopers;
        return this;
    }

    @Override
    public String toString() {
        return "ProjectsDto{" +
                "projectId=" + projectId +
                ", description='" + description + '\'' +
                ", dateAdded=" + dateAdded +
                ", countOfDevelopers=" + countOfDevelopers +
                '}';
    }
}
