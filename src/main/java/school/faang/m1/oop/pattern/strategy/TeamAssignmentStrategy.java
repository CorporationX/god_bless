package school.faang.m1.oop.pattern.strategy;

import java.util.List;

public interface TeamAssignmentStrategy {
    /*
        Метод должен принимать проект и список сотрудников и возвращать список сотрудников,
        соответствующих требованиям проекта.
     */
    public List<Employee> assignTeam(Project project, List<Employee> employees);

    default String name() {
        return getClass().getSimpleName();
    }
}
