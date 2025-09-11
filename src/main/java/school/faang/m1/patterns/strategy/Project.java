package school.faang.m1.patterns.strategy;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
public final class Project {
    int projectId; //уникальный идентификатор проекта;
    String name; //название проекта;
    Set<String> requiredSkills; // набор навыков, необходимых для проекта;
    List<Employee> teamMembers = new ArrayList<>(); // список сотрудников, назначенных на проект.

    public Project(int projectId, String name, Set<String> requiredSkills) {
        this.projectId = projectId;
        this.name = Objects.requireNonNull(name);
        setRequiredSkills(requiredSkills);
    }

    public void setRequiredSkills(Set<String> requiredSkills) {
        this.requiredSkills = new HashSet<>(Objects.requireNonNull(requiredSkills));
    }

    @Override
    public String toString() {
        return "Project{" + projectId + ", " + name + ", req=" + requiredSkills + "}";
    }
}
