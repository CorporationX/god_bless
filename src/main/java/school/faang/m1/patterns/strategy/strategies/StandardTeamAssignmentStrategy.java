package school.faang.m1.patterns.strategy.strategies;

import school.faang.m1.patterns.strategy.Employee;
import school.faang.m1.patterns.strategy.SkillCover;
import school.faang.m1.patterns.strategy.Project;
import school.faang.m1.patterns.strategy.TeamAssignmentStrategy;

import java.util.*;

/**
 * Жадная стратегия: набираем сотрудников, пока не покроем все скиллы
 */
public final class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        return SkillCover.assignTeam(project, employees);
    }
}