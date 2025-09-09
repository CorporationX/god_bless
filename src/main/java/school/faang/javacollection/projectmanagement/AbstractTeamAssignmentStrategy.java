package school.faang.javacollection.projectmanagement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static school.faang.javacollection.projectmanagement.EmployeeProjectsCount.incrementEmployeeProjectsCount;

public abstract class AbstractTeamAssignmentStrategy implements TeamAssignmentStrategy {
    protected List<Employee> findNecessaryEmployees(List<Employee> employees, Set<String> requiredSkills) {
        Set<String> remainingRequiredSkills = new HashSet<>(requiredSkills);
        List<Employee> resultList = new ArrayList<>();
        for (Employee employee : employees) {
            boolean isEmployeeHasRequiredSkills = remainingRequiredSkills.removeAll(employee.getSkills());
            if (isEmployeeHasRequiredSkills) {
                resultList.add(employee);
                incrementEmployeeProjectsCount(employee);
            }
            if (remainingRequiredSkills.isEmpty()) {
                return resultList;
            }
        }
        return resultList;
    }
}
