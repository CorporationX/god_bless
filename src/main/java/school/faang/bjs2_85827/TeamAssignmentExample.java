package school.faang.bjs2_85827;

import java.util.List;
import java.util.Set;

public class TeamAssignmentExample {
    public static void main(String[] args) {
        ProjectManager pm = new ProjectManager();

        Employee e1 = new Employee(1, "Lisa", Set.of("Java", "SQL"));
        Employee e2 = new Employee(2, "Frances", Set.of("JavaScript", "React"));
        Employee e3 = new Employee(3, "Sheila", Set.of("Java", "Project Management"));
        Employee e4 = new Employee(4, "Wayne", Set.of("SQL", "Python"));
        Employee e5 = new Employee(5, "Charlie", Set.of("React", "CSS"));

        pm.addEmployee(e1);
        pm.addEmployee(e2);
        pm.addEmployee(e3);
        pm.addEmployee(e4);
        pm.addEmployee(e5);

        Project p1 = new Project(101, "WebApp", Set.of("Java", "React", "SQL"));
        Project p2 = new Project(102, "DataPipeline", Set.of("Python", "SQL"));

        pm.addProject(p1);
        pm.addProject(p2);

        pm.setAssignmentStrategy(new StandardTeamAssignmentStrategy());
        pm.assignTeamToProject(101);
        System.out.println("Команда для WebApp (Standard): " + pm.getTeamForProject(101));

        pm.setAssignmentStrategy(new BalancedTeamAssignmentStrategy());
        pm.assignTeamToProject(102);
        System.out.println("Команда для DataPipeline (Balanced): " + pm.getTeamForProject(102));

        boolean assigned = pm.assignEmployeeToProject(102, e4);
        System.out.println(e4.getName() + " назначен вручную на DataPipeline: " +
                (assigned ? "успешно" : "не успешно"));

        pm.removeEmployeeFromProject(101, 2);
        System.out.println("Команда для WedApp после удаления: " + pm.getTeamForProject(101));

        p1.setRequiredSkills(Set.of("Java", "React"));
        pm.removeIneligibleEmployees(p1);
        System.out.println("Команда для WebApp после обновления навыков и удаления неподходящих: " +
                pm.getTeamForProject(101));

        List<Project> projectsForE3 = pm.findProjectsForEmployee(e3);
        System.out.print("Проекты, подходящие сотруднику " + e3.getName() + ": ");
        if (projectsForE3.isEmpty()) {
            System.out.println("(нет подходящих проектов)");
        } else {
            for (Project p : projectsForE3) {
                System.out.print(p.getName() + " (ID:" + p.getProjectId() + "), ");
            }
            System.out.println();
        }
    }
}

