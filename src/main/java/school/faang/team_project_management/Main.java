package school.faang.team_project_management;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        ProjectManager projectManager = new ProjectManager();

        projectManager.addEmployee("Alice", Set.of("Java", "SQL"));
        projectManager.addEmployee("Bob", Set.of("Python", "ML"));
        projectManager.addEmployee("Charlie", Set.of("React", "Java"));
        projectManager.addEmployee("Diana", Set.of("React", "Design"));

        // === Шаг 2: создать проекты ===
        projectManager.addProject("Backend API", Set.of("Java", "SQL"), new ArrayList<>());
        projectManager.addProject("Frontend UI", Set.of("React"), new ArrayList<>());
        projectManager.addProject("AI System", Set.of("Python"), new ArrayList<>());


        projectManager.setAssignmentStrategy(new StandartTeamAssignmentStrategy());

        // === Назначаем команды ===
        for (int i = 0; i < 3; i++) {
            projectManager.setTeamForProject(i);
        }

        // === Выводим результат по каждому проекту ===
        printProjects(projectManager.getProjects());

        // === Поиск проектов для Charlie ===
        System.out.println("\nПроекты, где Charlie может участвовать:");
        Employee charlie = projectManager.getEmployees().get(2);
        projectManager.findProjectsForEmployee(charlie).forEach(
                p -> System.out.println(" - " + p.getName())
        );

        // === Добавим Alice в AI вручную ===
        projectManager.assignEmployeeToProject(projectManager.getEmployees().get(0), 2);

        // === Удалим Bob из проекта AI ===
        projectManager.removeEmployeeFromProject(1, 2);

        // === Удалим неподходящих из Frontend ===
        Project frontend = projectManager.getProjects().get(1);
        projectManager.removeIneligibleEmployees(frontend);

        // === Финальный вывод ===
        System.out.println("\n== Финальный список проектов ==");
        printProjects(projectManager.getProjects());
    }

    public static void printProjects(List<Project> projects) {
        for (Project project : projects) {
            System.out.println("Проект: " + project.getName());
            for (Employee e : project.getTeamMembers()) {
                System.out.println(" - " + e.getName() + " | Скиллы: " + e.getSkills());
            }
            if (project.getTeamMembers().isEmpty()) {
                System.out.println(" - Команда пуста");
            }
        }
    }
}
