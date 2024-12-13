package school.faang.sprint_1.task_44950;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ProjectManager manager = new ProjectManager();
        
        manager.addEmployee(new Employee(1, "Erik",
                Set.of("Java",
                        "Python",
                        "SQL")));
        manager.addEmployee(new Employee(2, "Bagyshan",
                Set.of("Java",
                        "Docker",
                        "GCP cloud")));
        manager.addEmployee(new Employee(3, "Meerim",
                Set.of("JavaScript",
                        "Frontend")));
        
        manager.addProject(new Project(1, "OneCall Website",
                Set.of("Java",
                        "GCP cloud",
                        "Python",
                        "Frontend")));
        manager.addProject(new Project(2, "god_bless",
                Set.of("Java",
                        "SQL")));

        manager.setAssignmentStrategy(new StandardTeamAssignmentStrategy());
        manager.assignTeamToProject(1);
        manager.assignTeamToProject(2);

        System.out.println("OneCall:\n" + manager.getTeamForProject(1));
        System.out.println("god_bless:\n" + manager.getTeamForProject(2));

        Employee erik = manager.getTeamForProject(1).get(0);
        System.out.println(manager.findProjectsForEmployee(erik));
    }
}
