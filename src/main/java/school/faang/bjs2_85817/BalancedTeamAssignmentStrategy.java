package school.faang.bjs2_85817;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> resultList = new ArrayList<>();
        Set<String> requiredSkills = project.getRequiredSkills();

        for (String skill : requiredSkills) {
            Optional<Employee> employee = employees.stream()
                    .filter(emp -> emp.getSkills().contains(skill))
                    .min(Comparator.comparingInt(Employee::getProjectsCount));

            if (employee.isPresent() && !resultList.contains(employee.get())) {
                resultList.add(employee.get());
                incrementEmployeeProjectsCount(employee.get());
            }
        }
        return resultList;
    }
}
