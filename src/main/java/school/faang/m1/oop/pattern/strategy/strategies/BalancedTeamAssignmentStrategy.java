package school.faang.m1.oop.pattern.strategy.strategies;

import school.faang.m1.oop.pattern.strategy.Employee;
import school.faang.m1.oop.pattern.strategy.Project;
import school.faang.m1.oop.pattern.strategy.TeamAssignmentStrategy;

import java.util.*;
import java.util.function.ToIntFunction;

/**
 * Сбалансированная стратегия: такие же шаги, но кандидаты заранее отсортированы по нагрузке.
 */
public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {
    private final ToIntFunction<Employee> loadFn;

    /*
        передали функциональный интерфейс
     */
    public BalancedTeamAssignmentStrategy(ToIntFunction<Employee> loadFn) {
        this.loadFn = Objects.requireNonNull(loadFn);
    }

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        // предпочитаем сотрудников с меньшей нагрузкой
        List<Employee> sortedByload = new ArrayList<>(employees);
        sortedByload.sort(Comparator.comparingInt(loadFn));
        return new StandardTeamAssignmentStrategy().assignTeam(project, sortedByload);
    }
}
