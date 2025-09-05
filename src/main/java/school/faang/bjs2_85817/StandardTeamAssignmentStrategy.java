package school.faang.bjs2_85817;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> resultList = new ArrayList<>();
        Set<String> requiredSkills = project.getRequiredSkills();

        for (String skill : requiredSkills) {
            Optional<Employee> employee = employees.stream()
                    .filter(emp -> emp.getSkills().contains(skill))
                    .findFirst();
            if (employee.isPresent() && !resultList.contains(employee.get())) {
                employee.get().incrementProjectsCount();
                resultList.add(employee.get());
            }
        }
        return resultList.stream().toList();
    }
}
