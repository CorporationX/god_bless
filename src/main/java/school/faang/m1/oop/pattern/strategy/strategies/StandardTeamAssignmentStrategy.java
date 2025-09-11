package school.faang.m1.oop.pattern.strategy.strategies;

import school.faang.m1.oop.pattern.strategy.Employee;
import school.faang.m1.oop.pattern.strategy.Project;
import school.faang.m1.oop.pattern.strategy.ProjectManager;
import school.faang.m1.oop.pattern.strategy.TeamAssignmentStrategy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Жадная стратегия: набираем сотрудников, пока не покроем все скиллы
 */
public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        Set<String> needed = new HashSet<>(project.getRequiredSkills());
        List<Employee> team = new ArrayList<>();
        // Кандидаты: Фильтр: имеют хотя бы один нужный навык
        List<Employee> candidates = employees.stream()
                .filter(e -> haveAtLeastOneSkill(e.getSkills(), needed))
                .collect(Collectors.toList());

        while (!needed.isEmpty() && !candidates.isEmpty()) {
            // Выбираем сотрудника, который добавит максимум новых покрытых навыков
            Employee best = null;
            int bestMatchCount = -1;
            for (Employee e : candidates) {
                int currentSkillsCount = numberOfNeededSkills(e, needed);
                if (currentSkillsCount > bestMatchCount) {
                    bestMatchCount = currentSkillsCount;
                    best = e;
                }
            }
            if (best == null || bestMatchCount <= 0) {
                break;
            } //дальше не смотрим
            team.add(best);
            //убираем покрытые бест навыки
            needed.removeAll(best.getSkills());
            candidates.remove(best);
        }
        return team;
    }

    private int numberOfNeededSkills(Employee e, Set<String> needed) {
        int g = 0;
        for (String s : e.getSkills()) {
            if (needed.contains(s)) {
                g++;
            }
        }
        return g;
    }


    private boolean haveAtLeastOneSkill(Set<String> skills, Set<String> needed) {
        return ProjectManager.intersects(skills, needed);
    }
}
