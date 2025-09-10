package school.faang.javacollection.projectmanagement;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StandardTeamAssignmentStrategyTest {

    private final StandardTeamAssignmentStrategy strategy = new StandardTeamAssignmentStrategy();

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testAssignTeam(TestCase tc) {
        List<Employee> result = strategy.assignTeam(tc.project, tc.employees);

        // Проверяем id тех, кто попал в команду
        assertThat(result.stream().map(Employee::getId).toList())
                .containsExactlyElementsOf(tc.expectedEmployeeIds);

        // Проверяем, что projectsCount у нужных сотрудников увеличился
        assertThat(tc.employees.stream().map(Employee::getProjectsCount).toList())
                .containsExactlyElementsOf(tc.expectedProjectsCounts);
    }

    static Stream<TestCase> provideTestCases() {
        Employee e1 = new Employee(1, "John", Set.of("Java"));
        Employee e2 = new Employee(2, "Alice", Set.of("SQL"));
        Employee e3 = new Employee(3, "Bob", Set.of("Java"));
        Employee e4 = new Employee(4, "Mike", Set.of("Go"));

        return Stream.of(
                // Все навыки покрыты двумя сотрудниками
                new TestCase(
                        new Project(1, "Proj1", Set.of("Java", "SQL"), null),
                        List.of(copy(e1), copy(e2), copy(e3), copy(e4)),
                        List.of(1, 2),
                        List.of(1, 1, 0, 0)
                ),
                // Только часть навыков покрыта
                new TestCase(
                        new Project(2, "Proj2", Set.of("Java", "Kotlin"), null),
                        List.of(copy(e1), copy(e2), copy(e3), copy(e4)),
                        List.of(1),
                        List.of(1, 0, 0, 0)
                ),
                // Несколько сотрудников с одинаковым навыком -> добавляется первый
                new TestCase(
                        new Project(3, "Proj3", Set.of("Java"), null),
                        List.of(copy(e1), copy(e3)),
                        List.of(1),
                        List.of(1, 0)
                ),
                // Сотрудник без нужных навыков не добавляется
                new TestCase(
                        new Project(4, "Proj4", Set.of("SQL"), null),
                        List.of(copy(e4)),
                        List.of(),
                        List.of(0)
                ),
                // Нет сотрудников
                new TestCase(
                        new Project(5, "Proj5", Set.of("Java"), null),
                        List.of(),
                        List.of(),
                        List.of()
                ),
                // У проекта нет навыков
                new TestCase(
                        new Project(6, "Proj6", Set.of(), null),
                        List.of(copy(e1), copy(e2), copy(e3), copy(e4)),
                        List.of(),
                        List.of(0, 0, 0, 0)
                )
        );
    }

    private record TestCase(
            Project project,
            List<Employee> employees,
            List<Integer> expectedEmployeeIds,
            List<Integer> expectedProjectsCounts
    ) {}

    private static Employee copy(Employee e) {
        return new Employee(e.getId(), e.getName(), Set.copyOf(e.getSkills()));
    }
}