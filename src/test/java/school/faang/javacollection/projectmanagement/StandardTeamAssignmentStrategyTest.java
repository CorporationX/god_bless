package school.faang.javacollection.projectmanagement;

import org.junit.jupiter.api.Test;
import school.faang.bjs2_85817.Employee;
import school.faang.bjs2_85817.Project;
import school.faang.bjs2_85817.StandardTeamAssignmentStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class StandardTeamAssignmentStrategyTest {

    @Test
    void testAssignTeam() {
        var strategy = new StandardTeamAssignmentStrategy();
        Project project = new Project(
                1,
                "project1",
                Set.of("1", "2", "3", "4"),
                new ArrayList<>()
        );
        List<Employee> employeeList = new ArrayList<>();
        Employee emp1 = new Employee(1, "emp1", Set.of("1", "4"));
        Employee emp2 = new Employee(2, "emp2", Set.of("2", "6"));
        Employee emp3 = new Employee(3, "emp3", Set.of("3", "6"));
        Employee emp4 = new Employee(4, "emp4", Set.of("4", "5"));
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);

        List<Employee> resultSet = strategy.assignTeam(project, employeeList);
        System.out.println(resultSet);

        assertThat(resultSet).isEqualTo(Set.of(emp1, emp2, emp3));
    }
}