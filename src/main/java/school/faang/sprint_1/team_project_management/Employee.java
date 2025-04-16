package school.faang.sprint_1.team_project_management;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class Employee {
    private int id;
    private String name;
    private Set<String> skills;
    private int projectsAmount;

    public void decrementProjectsAmount() {
        this.projectsAmount--;
    }

    public void incrementProjectsAmount() {
        this.projectsAmount++;
    }
}
