package school.faang.ProjectTeamManagement.strategy;

import school.faang.ProjectTeamManagement.model.Employee;
import school.faang.ProjectTeamManagement.model.Project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collections;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {

    private final Map<Integer, Integer> employeeLoad;

    public BalancedTeamAssignmentStrategy(Map<Integer, Integer> employeeLoad) {
        this.employeeLoad = employeeLoad;
    }

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {

        return distributeTeam(project, employees);

    }

    private List<Employee> findSuitableEmployees(Project project, List<Employee> employees) {

        List<Employee> suitable = new ArrayList<>();

        for (Employee employee : employees) {
            Set<String> skills = new HashSet<>(employee.getSkills());
            skills.retainAll(project.getRequiredSkills());

            if (!skills.isEmpty()) {
                suitable.add(employee);
            }
        }
        sortedByLoad(suitable);

        return suitable;
    }

    private void sortedByLoad(List<Employee> employees) {
        Collections.sort(employees, (e1, e2) ->
                Integer.compare(employeeLoad.getOrDefault(e1.getId(), 0),
                             employeeLoad.getOrDefault(e2.getId(), 0))
        );
    }

    private List<Employee> distributeTeam(Project project, List<Employee> employees) {

        List<Employee> suitable = findSuitableEmployees(project, employees);

        List<Employee> team = new ArrayList<>();
        Set<String> coveredSkills = new HashSet<>();

        for (Employee employee : suitable) {
            Set<String> newSkills = new HashSet<>(employee.getSkills());
            newSkills.removeAll(coveredSkills);

            if (!newSkills.isEmpty()) {
                team.add(employee);
                coveredSkills.addAll(newSkills);
                increaseLoad(employee);
            }
            if (coveredSkills.containsAll(project.getRequiredSkills())) {
                break;
            }
        }

        return team;

    }

    private void increaseLoad(Employee employee) {
        employeeLoad.put(employee.getId(), employeeLoad.getOrDefault(employee.getId(), 0) + 1);
    }
}
