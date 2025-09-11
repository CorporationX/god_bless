package school.faang.m1.oop.pattern.strategy;

import school.faang.m1.oop.pattern.strategy.strategies.BalancedTeamAssignmentStrategy;
import school.faang.m1.oop.pattern.strategy.strategies.StandardTeamAssignmentStrategy;

import java.util.Map;
import java.util.Set;

/**
 *  Демонстрация
 */
public class Main {
    public static void main(String[] args) {
        ProjectManager pm = new ProjectManager();

        // Сотрудники
        pm.addEmployee(new Employee(1, "Alice", Set.of("java", "spring", "sql")));
        pm.addEmployee(new Employee(2, "Bob", Set.of("react", "js", "css")));
        pm.addEmployee(new Employee(3, "Carol", Set.of("kotlin", "java", "docker")));
        pm.addEmployee(new Employee(4, "Dave", Set.of("aws", "terraform", "docker")));
        pm.addEmployee(new Employee(5, "Eve", Set.of("python", "ml", "sql")));
        pm.addEmployee(new Employee(6, "Frank", Set.of("js", "node", "docker")));

        // Проекты
        pm.addProject(new Project(101, "Trading UI", Set.of("js", "react", "css", "docker")));
        pm.addProject(new Project(202, "Pricing Engine", Set.of("java", "spring", "sql", "docker")));

        // --- Стандартная стратегия ---
        pm.setAssignmentStrategy(new StandardTeamAssignmentStrategy());
        pm.assignTeamToProject(101);
        printTeam(pm, 101, "Standard");
        System.out.println("Uncovered(101): " + pm.uncoveredSkills(101));
        System.out.println();

        // Немного повысим нагрузку части сотрудников: назначим стандартом и второй проект
        pm.assignTeamToProject(202);
        printTeam(pm, 202, "Standard");
        System.out.println("Uncovered(202): " + pm.uncoveredSkills(202));
        System.out.println();

        // --- Сбалансированная стратегия ---
        // Создадим стратегию, учитывающую текущую нагрузку из менеджера
        pm.setAssignmentStrategy(new BalancedTeamAssignmentStrategy(pm.loadFn()));
        pm.assignTeamToProject(101); // переназначим проект 101 по balanced
        printTeam(pm, 101, "Balanced (reassign)");
        System.out.println("Uncovered(101): " + pm.uncoveredSkills(101));
        System.out.println();

        // --- Доп. методы ---
        System.out.println("Projects suitable for Bob (id=2): " +
                pm.findProjectsForEmployee(new Employee(2, "Bob", Set.of("react", "js", "css")))
                        .stream().map(Project::getName).toList());

        // Попытка добавить сотрудника в проект с индивидуальным полным покрытием:
        boolean ok = pm.assignEmployeeToProject(202, new Employee(1, "Alice", Set.of("java", "spring", "sql")));
        System.out.println("Assign Alice individually to 202 with full coverage? " + ok);
        printTeam(pm, 202, "After individual attempt (Alice)");
        System.out.println();

        // Модификация требований и удаление несоответствующих
        Project p101 = new Project(101, "Trading UI", Set.of("react")); // упростим требования
        // Заменим объект проекта 101 внутри менеджера аккуратно (для демонстрации — обычно через setter)
        // Для простоты получим старый и поменяем ему требования:
        // (в реальном коде мы бы держали ссылку и просто setRequiredSkills)
        // Здесь получим текущий из менеджера:
        try {
            var current101 = pm.getTeamMembers(101); // просто вызов, чтобы убедиться, что проект есть
            // Дополнительно удалим несоответствующих по обновлённым требованиям:
            var proj = getProjectByReflection(pm, 101); // трюк для демо; в реальном коде добавьте getProject(...)
            proj.setRequiredSkills(Set.of("react"));
            pm.removeIneligibleEmployees(proj);
            printTeam(pm, 101, "After requirement change + cleanup");
        } catch (Exception ignored) {
            // ignored
        }
    }

    private static void printTeam(ProjectManager pm, int projectId, String label) {
        System.out.println("[" + label + "] Project " + projectId + " team:");
        for (Employee e : pm.getTeamForProject(projectId)) {
            System.out.println(" - " + e.getName() + " (id=" + e.getId() + "), load=" + pm.getLoad(e.getId())
                    + ", skills=" + e.getSkills());
        }
    }

    // Небольшой хак для демо, чтобы достать проект и поменять требования (иначе — добавьте публичный getter в PM).
    private static Project getProjectByReflection(ProjectManager pm, int projectId) {
        try {
            var f = ProjectManager.class.getDeclaredField("projects");
            f.setAccessible(true);
            @SuppressWarnings("unchecked")
            Map<Integer, Project> map = (Map<Integer, Project>) f.get(pm);
            return map.get(projectId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}