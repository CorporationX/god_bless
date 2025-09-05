package school.faang.bjs2_85817;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectManager {

    private List<Employee> employeeList;
    private Map<Integer, Project> projectSet;
    private TeamAssignmentStrategy assignmentStrategy;

    public void assignTeamToProject(int projectId) {
        Project project = projectSet.get(projectId);
        List<Employee> requiredEmployee = assignmentStrategy.assignTeam(
                project,
                employeeList
        );
        project.setTeamMembers(requiredEmployee);
        projectSet.put(projectId, project);
    }

    public List<Employee> getTeamForProject(int projectId) {
        return projectSet.get(projectId).getTeamMembers();
    }
}
