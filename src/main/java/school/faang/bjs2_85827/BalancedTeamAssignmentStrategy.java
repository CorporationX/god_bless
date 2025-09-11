package school.faang.bjs2_85827;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        Set<String> requiredSkills = new HashSet<>(project.getRequiredSkills());
        List<Employee> team = new ArrayList<>();
        Set<String> coveredSkills = new HashSet<>();

        List<Employee> sortedEmployee = new ArrayList<>(employees);
        sortedEmployee.sort(Comparator.comparingInt(Employee::getAssignedProjectsCount));

        for (Employee e : sortedEmployee) {
            Set<String> employeeSkills = e.getSkills();
            boolean contributes = false;
            for (String skill : requiredSkills) {
                if (employeeSkills.contains(skill) && !coveredSkills.contains(skill)) {
                    contributes = true;
                    break;
                }
            }

            if (contributes) {
                team.add(e);
                for (String skill : employeeSkills) {
                    if (requiredSkills.contains(skill)) {
                        coveredSkills.add(skill);
                    }
                }
            }
            if (coveredSkills.containsAll(requiredSkills)) {
                break;
            }
        }
        return team;
    }
}