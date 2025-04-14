package school.faang.projectteammanagement;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ProjectManager {

    private List<Project> companyProjects;
    private List<Employee> allEmployees;
    private TeamAssignmentStrategy activeStrategy;


    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        this.activeStrategy = strategy;
    }

    public void assignTeamToProject(int projectId) {
        getProjectById(projectId).setTeamMembers(
                activeStrategy.assignTeam(getProjectById(projectId), allEmployees)
        );
    }

    public List<Employee> getTeamForProject(int projectId) {
        return getProjectById(projectId).getTeamMembers();
    }

    private Project getProjectById(int id) {
        return companyProjects
                .stream()
                .filter(project -> (project.getProjectId() == id))
                .findFirst()
                .get();
    }
}
