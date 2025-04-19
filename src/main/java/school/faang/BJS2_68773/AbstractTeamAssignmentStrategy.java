package school.faang.BJS2_68773;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractTeamAssignmentStrategy implements TeamAssignmentStrategy {
    protected final List<Employee> assignTeamDefault(Project project, List<Employee> employees,
                                                     Comparator<Employee> comparator) {
        employees.sort(comparator);
        List<Employee> teamEmployees = new ArrayList<>();
        Set<Skill> projectRequiredSkills = new HashSet<>(project.getRequiredSkills());
        employees.stream().takeWhile(empl -> !projectRequiredSkills.isEmpty())
                .forEach(employee -> {
                    if (SkillUtils.hasCommonSkills(projectRequiredSkills, employee.getSkills())) {
                        SkillUtils.subtractSkillsCoveredBy(employee, projectRequiredSkills);
                        teamEmployees.add(employee);
                    }
                });
        return teamEmployees;
    }
}
