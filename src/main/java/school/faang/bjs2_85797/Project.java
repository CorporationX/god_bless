package school.faang.bjs2_85797;

import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
public class Project {
    private Integer projectId; //id проекта
    private String name; //название проекта
    private Set<String> requiredSkills; //набор навыков, необходимых для проекта
    private List<Employee> teamMembers; //список сотрудников, назначенных на проект

    public Project(Integer projectId, String name, Set<String> requiredSkills) {
        this.projectId = projectId;
        this.name = name;
        this.requiredSkills = requiredSkills;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Project project = (Project) o;
        return Objects.equals(projectId, project.projectId)
                && Objects.equals(name, project.name)
                && Objects.equals(requiredSkills, project.requiredSkills)
                && Objects.equals(teamMembers, project.teamMembers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, name, requiredSkills, teamMembers);
    }
}
