package school.faang.javacollection.projectmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static school.faang.javacollection.projectmanagement.EmployeeProjectsCount.incrementEmployeeProjectsCount;

public abstract class AbstractTeamAssignmentStrategy implements TeamAssignmentStrategy {
    protected List<Employee> findNecessaryEmployees(
            List<Employee> employees,
            Set<String> requiredSkills) {
        List<Employee> resultList = new ArrayList<>();
        for (Employee employee : employees) {
            if (requiredSkills.removeAll(employee.getSkills())) {
                resultList.add(employee);
                incrementEmployeeProjectsCount(employee);
            }
            if (requiredSkills.isEmpty()) {
                return resultList;
            }
        }
        return resultList;
    }
}
