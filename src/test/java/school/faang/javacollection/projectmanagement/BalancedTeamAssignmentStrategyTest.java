package school.faang.javacollection.projectmanagement;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BalancedTeamAssignmentStrategyTest {

    private final BalancedTeamAssignmentStrategy strategy = new BalancedTeamAssignmentStrategy();

    @ParameterizedTest(name = "Scenario {index}")
    @MethodSource("provideScenarios")
    void testAssignTeam(Project project,
                        List<Employee> employees,
                        List<Integer> expectedIds,
                        List<Integer> expectedProjectsCount) {
        List<Employee> result = strategy.assignTeam(project, employees);

        assertThat(result.stream().map(Employee::getId).toList())
                .isEqualTo(expectedIds);

        assertThat(employees.stream().map(Employee::getProjectsCount).toList())
                .isEqualTo(expectedProjectsCount);
    }

    static Stream<Arguments> provideScenarios() {
        return Stream.of(
                // 1. Нет сотрудников
                org.junit.jupiter.params.provider.Arguments.of(
                        new Project(1, "Proj", Set.of("Java"), null),
                        List.<Employee>of(),
                        List.of(),
                        List.of()
                ),

                // 2. У проекта нет навыков
                org.junit.jupiter.params.provider.Arguments.of(
                        new Project(1, "Proj", Set.of(), null),
                        List.of(new Employee(1, "John", Set.of("Java"))),
                        List.of(),
                        List.of(0)
                ),

                // 3. Два сотрудника, оба нужны, но сначала берётся тот у кого меньше projectsCount
                org.junit.jupiter.params.provider.Arguments.of(
                        new Project(1, "Proj", Set.of("Java", "SQL"), null),
                        List.of(
                                new Employee(1, "John", Set.of("Java")),
                                makeEmployee(2, "Alice", Set.of("SQL"), 1)
                        ),
                        List.of(1, 2),
                        List.of(1, 2)
                ),

                // 4. Несколько сотрудников с одинаковым skill → берётся с меньшим projectsCount
                org.junit.jupiter.params.provider.Arguments.of(
                        new Project(1, "Proj", Set.of("Java"), null),
                        List.of(
                                new Employee(1, "John", Set.of("Java")),
                                makeEmployee(2, "Alice", Set.of("Java"), 2)
                        ),
                        List.of(1),
                        List.of(1, 2)
                ),

                // 5. Частичное покрытие навыков
                org.junit.jupiter.params.provider.Arguments.of(
                        new Project(1, "Proj", Set.of("Java", "Kotlin"), null),
                        List.of(new Employee(1, "John", Set.of("Java"))),
                        List.of(1),
                        List.of(1)
                ),

                // 6. Ранний выход после покрытия всех навыков
                org.junit.jupiter.params.provider.Arguments.of(
                        new Project(1, "Proj", Set.of("Java"), null),
                        List.of(
                                new Employee(1, "John", Set.of("Java")),
                                new Employee(2, "Alice", Set.of("SQL"))
                        ),
                        List.of(1),
                        List.of(1, 0)
                )
        );
    }

    private static Employee makeEmployee(int id, String name, Set<String> skills, int projectsCount) {
        Employee e = new Employee(id, name, skills);
        e.setProjectsCount(projectsCount);
        return e;
    }
}