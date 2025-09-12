package school.faang.m1.patterns.strategy.strategies;

import school.faang.m1.patterns.strategy.Employee;
import school.faang.m1.patterns.strategy.Project;
import school.faang.m1.patterns.strategy.SkillCover;
import school.faang.m1.patterns.strategy.TeamAssignmentStrategy;

import java.util.*;
import java.util.function.ToIntFunction;

/**
 * Сбалансированная стратегия: такие же шаги, но она будет минимизировать перекос нагрузки,
 * учитывая текущее число назначений на каждого сотрудника,
 * массив сотрудников упорядочивается по нагрузке перед тем, как мы начинаем распределять по командам, что
 * заставляет выбирать менее нагруженного для новой команды, при одинаковом наборе скилов
 */
public final class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {
    private final ToIntFunction<Employee> loadFn;

    public BalancedTeamAssignmentStrategy(ToIntFunction<Employee> loadFn) {
        this.loadFn = Objects.requireNonNull(loadFn);
    }

    /*
     * Предпочитаем сотрудников с меньшей нагрузкой (но алгоритм подбора — общий)
     */
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> sortedByLoad = new ArrayList<>(employees);
        sortedByLoad.sort(Comparator.comparingInt(loadFn));
        return SkillCover.assignTeam(project, sortedByLoad);
    }
}