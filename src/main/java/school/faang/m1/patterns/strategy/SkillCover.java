package school.faang.m1.patterns.strategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
    Общий жадный алгоритм покрытия навыков
    Кандидаты: Фильтр: имеют хотя бы один нужный навык
    Алгоритм выбираем сотрудника, который добавит максимум новых покрытых навыков
    Если сотрудников с навыками нет, выходим и дальше не строим команду\проект
    Убираем покрытые бест навыки, из проекта по мере заполнения команды специалистами
 */
public final class SkillCover {
    public SkillCover() {}

    public static List<Employee> assignTeam(Project project, List<Employee> employees) {
        Set<String> needed = new HashSet<>(project.getRequiredSkills());
        List<Employee> team = new ArrayList<>();

        List<Employee> candidates = employees.stream()
                .filter(e -> haveAtLeastOneSkill(e.skills(), needed))
                .collect(Collectors.toList());

        while (!needed.isEmpty() && !candidates.isEmpty()) {

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
            }
            team.add(best);

            needed.removeAll(best.skills());
            candidates.remove(best);
        }
        return team;
    }

    private static int numberOfNeededSkills(Employee e, Set<String> needed) {
        int g = 0;
        for (String s : e.skills()) {
            if (needed.contains(s)) {
                g++;
            }
        }
        return g;
    }


    private static boolean haveAtLeastOneSkill(Set<String> skills, Set<String> needed) {
        return ProjectManager.intersects(skills, needed);
    }
}
