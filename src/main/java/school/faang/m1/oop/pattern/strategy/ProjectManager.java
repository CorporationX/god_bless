package school.faang.m1.oop.pattern.strategy;

import school.faang.m1.oop.pattern.strategy.strategies.BalancedTeamAssignmentStrategy;
import school.faang.m1.oop.pattern.strategy.strategies.StandardTeamAssignmentStrategy;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class ProjectManager {
    private final Map<Integer, Employee> employees = new HashMap<>();
    private final Map<Integer, Project> projects = new HashMap<>();
    // Простая модель нагрузки: сколько проектов назначено каждому сотруднику
    private final Map<Integer, Integer> assignmentCounts = new HashMap<>();

    private TeamAssignmentStrategy strategy = new StandardTeamAssignmentStrategy();

    /**
     * --- Базовые операции ---
     */
    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy);
    }

    // — добавляет сотрудника в систему.
    public void addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
        assignmentCounts.putIfAbsent(employee.getId(), 0);
    }

    public void addProject(Project project) {
        projects.put(project.getProjectId(), project);
    }

    public List<Employee> getTeamForProject(int projectId) {
        Project p = getProjectOrThrow(projectId);
        return List.copyOf(p.getTeamMembers());
    }

    /**
     * Назначить команду проекту по выбранной стратегии.
     */
    public void assignTeamToProject(int projectId) {
        Project project = getProjectOrThrow(projectId);
        // Кандидаты — все сотрудники (можно фильтровать по пересечению навыков для ускорения)
        List<Employee> all = new ArrayList<>(employees.values());

        // Если выбрана Balanced, передадим функцию нагрузки
        if (strategy instanceof BalancedTeamAssignmentStrategy) {
            // уже создана с loadFn в конструкторе — ничего делать не надо
        }

        List<Employee> team = strategy.assignTeam(project, all);

        // Обновляем команду проекта (очистим прежнюю, скорректируем нагрузки)
        // Сначала снимаем кредиты с уже назначенных
        for (Employee e : project.getTeamMembers()) {
            decrementLoad(e.getId());
        }
        project.getTeamMembers().clear();
        project.getTeamMembers().addAll(team);
        // Повышаем кредиты новым
        for (Employee e : team) {
            incrementLoad(e.getId());
        }
    }

    /** --- Доп. задание --- */

    /**
     * Найти проекты, где сотрудник пригоден (имеет хотя бы один требуемый навык).
     */
    public List<Project> findProjectsForEmployee(Employee employee) {
        return projects.values().stream()
                .filter(p -> intersects(employee.getSkills(), p.getRequiredSkills()))
                .sorted(Comparator.comparing(Project::getProjectId))
                .collect(Collectors.toList());
    } // — возвращает список проектов, для которых сотрудник обладает необходимыми навыками.

    /**
     * Добавить сотрудника в проект, если у него есть все требуемые навыки проекта.
     */
    public boolean assignEmployeeToProject(int projectId, Employee employee) {
        Project p = getProjectOrThrow(projectId);
        if (employee.getSkills().containsAll(p.getRequiredSkills())) {
            if (!p.getTeamMembers().contains(employee)) {
                p.getTeamMembers().add(employee);
                incrementLoad(employee.getId());
            }
            return true;
        }
        return false;
    } // — добавляет сотрудника в команду проекта, если у него есть все требуемые навыки.

    public boolean removeEmployeeFromProject(int projectId, int employeeId) {
        Project p = getProjectOrThrow(projectId);
        boolean removed = p.getTeamMembers().removeIf(e -> e.getId() == employeeId);
        if (removed) {
            decrementLoad(employeeId);
        }
        return removed;
    } // — удаляет сотрудника из команды проекта.

    public List<Employee> getTeamMembers(int projectId) {
        return getTeamForProject(projectId);
    } // — возвращает список сотрудников, назначенных на проект.

    /**
     * Удалить из команды проекта тех, кто больше не соответствует требованиям.
     * Под "несоответствием" трактуем отсутствие пересечения навыков сотрудника с актуальными requiredSkills.
     * (Если нужно — замените на строгую проверку containsAll).
     */
    public void removeIneligibleEmployees(Project project) {
        Iterator<Employee> it = project.getTeamMembers().iterator();
        while (it.hasNext()) {
            Employee e = it.next();
            if (!intersects(e.getSkills(), project.getRequiredSkills())) {
                it.remove();
                decrementLoad(e.getId());
            }
        }
    }


    /**
     * --- Утилиты и проверки покрытия ---
     */

    public Set<String> uncoveredSkills(int projectId) {
        Project p = getProjectOrThrow(projectId);
        Set<String> uncovered = new HashSet<>(p.getRequiredSkills());
        for (Employee e : p.getTeamMembers()) {
            uncovered.removeAll(e.getSkills());
        }
        return uncovered;
    }

    public int getLoad(int employeeId) {
        return assignmentCounts.getOrDefault(employeeId, 0);
    }

    public ToIntFunction<Employee> loadFn() {
        return e -> getLoad(e.getId());
    }

    private Project getProjectOrThrow(int projectId) {
        Project p = projects.get(projectId);
        if (p == null) {
            throw new NoSuchElementException("Project " + projectId + " not found");
        }
        return p;
    }

    public static boolean intersects(Set<String> a, Set<String> b) {
        for (String x : a) {
            if (b.contains(x)) {
                return true;
            }
        }
        return false;
    }

    private void incrementLoad(int employeeId) {
        assignmentCounts.merge(employeeId, 1, Integer::sum);
    }

    private void decrementLoad(int employeeId) {
        assignmentCounts.merge(employeeId, -1, Integer::sum);
        if (assignmentCounts.get(employeeId) < 0) {
            assignmentCounts.put(employeeId, 0);
        }
    }
}
