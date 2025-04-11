package school.faang.team_project_management;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // === Шаг 1: создать сотрудников ===
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(0, "Alice", Set.of("Java", "SQL"), 2));
        employees.add(new Employee(1, "Bob", Set.of("Python", "ML"), 1));
        employees.add(new Employee(2, "Charlie", Set.of("React", "Java"), 0));
        employees.add(new Employee(3, "Diana", Set.of("React", "Design"), 3));

        // === Шаг 2: создать проекты ===
        Project backend = new Project(0, "Backend API", Set.of("Java", "SQL"), new ArrayList<>());
        Project frontend = new Project(1, "Frontend UI", Set.of("React"), new ArrayList<>());
        Project ai = new Project(2, "AI System", Set.of("Python"), new ArrayList<>());

        List<Project> projects = List.of(backend, frontend, ai);

        // === Шаг 3: создать ProjectManager со стандартной стратегией ===
        ProjectManager manager = new ProjectManager(employees, projects, new StandartTeamAssignmentStrategy());

        printHeader("Назначение по стандартной стратегии");
        assignTeamsAndPrint(manager, projects, employees);

        // === Шаг 4: переключиться на сбалансированную стратегию ===
        printHeader("Переключение на BalancedStrategy");
        manager.setAssignmentStrategy(new BalancedTeamAssignmentStrategy());
        assignTeamsAndPrint(manager, projects, employees);

        // === Шаг 5: найти проекты для Charlie ===
        printHeader("Проекты, где Charlie может участвовать");
        Employee charlie = employees.get(2);
        manager.findProjectsForEmployee(charlie).forEach(
                project -> System.out.println("- " + project.getName())
        );

        // === Шаг 6: вручную добавить Alice в проект AI ===
        printHeader("Добавляем Alice в AI System");
        manager.assignEmployeeToProject(employees.get(0), 2);
        printProjects(projects);

        // === Шаг 7: удалить Bob из проекта AI ===
        printHeader("Удаляем Bob из AI System");
        manager.removeEmployeeFromProject(1, 2);
        printProjects(projects);
        printEmployees(employees);

        // === Шаг 8: удалить неподходящих участников из проекта Frontend ===
        printHeader("Удаляем неподходящих сотрудников из проекта Frontend UI");
        manager.removeIneligibleEmployees(frontend);
        printProjects(projects);
    }

    private static void assignTeamsAndPrint(ProjectManager manager, List<Project> projects, List<Employee> employees) {
        for (int i = 0; i < projects.size(); i++) {
            manager.assignTeamToProject(i);
        }
        printProjects(projects);
        printEmployees(employees);
    }

    private static void printProjects(List<Project> projects) {
        for (Project project : projects) {
            System.out.printf("Проект: %s | Скиллы: %s%n", project.getName(), project.getRequiredSkills());
            if (project.getTeamMembers().isEmpty()) {
                System.out.println("  Команда: (пусто)");
            } else {
                for (Employee e : project.getTeamMembers()) {
                    System.out.printf("  - %s (ID %d) | Скиллы: %s | Проектов: %d%n",
                            e.getName(), e.getId(), e.getSkills(), e.getProjectsAmount());
                }
            }
        }
}
