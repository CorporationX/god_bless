package school.faang.stream1.projectteammanagement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface TeamAssignmentStrategy {
    List<Employee> assignTeam(Project project, List<Employee> employees);

    static List<Employee> coverAllSkills(Set<String> skills, List<Employee> sortedListOfEmployees) {
        Set<String> requiredSkillsCopy = new HashSet<>(skills);
        List<Employee> result = new ArrayList<>();
        for (Employee employee : sortedListOfEmployees) {
            boolean match = false;
            for (String skill : employee.getSkills()) {
                match = requiredSkillsCopy.remove(skill) || match;
            }
            if (match) {
                result.add(employee);
            }
            if (requiredSkillsCopy.isEmpty()) {
                return result;
            }
        }
        return null;
    }
}
