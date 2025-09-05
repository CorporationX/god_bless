package school.faang.bjs2_85817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        Employee emp1 = new Employee(1, "emp1", Set.of("1", "2"));
        Employee emp2 = new Employee(2, "emp2", Set.of("2", "1"));
        Employee emp3 = new Employee(3, "emp3", Set.of("1", "2"));
        Employee emp4 = new Employee(4, "emp4", Set.of("1", "2"));
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);

        int projectId1 = 1;
        int projectId2 = 2;
        int projectId3 = 3;
        Map<Integer, Project> projects = new HashMap<>();
        Project project1 = new Project(
                1,
                "project1",
                Set.of("1", "2"),
                new ArrayList<>()
        );
        Project project2 = new Project(
                2,
                "project1",
                Set.of("1", "2"),
                new ArrayList<>()
        );
        Project project3 = new Project(
                3,
                "project1",
                Set.of("1", "2"),
                new ArrayList<>()
        );
        projects.put(projectId1, project1);
        projects.put(projectId2, project2);
        projects.put(projectId3, project3);

        ProjectManager projectManager = new ProjectManager();
        projectManager.setEmployeeList(employeeList);
        projectManager.setProjectSet(projects);

        projectManager.setAssignmentStrategy(new BalancedTeamAssignmentStrategy());
        projectManager.assignTeamToProject(projectId1);
        projectManager.assignTeamToProject(projectId2);
        projectManager.assignTeamToProject(projectId3);
        System.out.println(projectManager.getEmployeeList());
    }
}
