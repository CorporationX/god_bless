package school.faang.projectteammanagement;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    //добавляет сотрудника в систему. (без проверки уникальности)
    public boolean addEmployee(Employee employee) {
        this.allEmployees = new ArrayList<>(allEmployees);
        return allEmployees.add(employee);
    }

    //возвращает список проектов, для которых сотрудник обладае необходимыми навыками.
    public List<Project> findProjectsForEmployee(Employee employee) {
        return companyProjects.stream()
                .filter(p -> p.getRequiredSkills().stream().anyMatch(employee.getSkills()::contains))
                .collect(Collectors.toList());
    }

    //добавляет сотрудника в команду проекта, если у него есть все требуемые навыки.
    public boolean assignEmployeeToProject(int projectId, Employee employee) {
        Project projectById = getProjectById(projectId);
        boolean containsAll = projectById.getRequiredSkills().containsAll(employee.getSkills());
        if (containsAll) {
            projectById.getTeamMembers().add(employee);
        }
        return containsAll;
    }

    public void removeEmployeeFromProject(int projectId, int employeeId) {
        Project projectById = getProjectById(projectId);
        projectById.setTeamMembers(
                projectById.getTeamMembers().stream().filter(e -> e.getId() != employeeId).toList()
        );
    }

    //дубликат, но раз посите (мало ли апи требует)
    public List<Employee> getTeamMembers(int projectId) {
        return getTeamForProject(projectId);
    }

    //который удаляет из команды проекта тех сотрудников, которые больше не соответствуют его требованиям
    //(например, при изменении набора необходимых навыков).
    public List<Employee> removeIneligibleEmployees(Project project) {
        List<Employee> employeesToRemove = project.getTeamMembers().stream()
                .filter(e -> e.getSkills().stream().noneMatch(project.getRequiredSkills()::contains))
                .collect(Collectors.toList());
        employeesToRemove.forEach(project.getTeamMembers()::remove);
        return employeesToRemove;
    }

    private Project getProjectById(int id) {
        return companyProjects
                .stream()
                .filter(project -> (project.getProjectId() == id))
                .findFirst()
                .get();
    }
}
