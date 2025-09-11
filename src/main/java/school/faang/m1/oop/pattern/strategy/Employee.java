package school.faang.m1.oop.pattern.strategy;

import lombok.Getter;

import java.util.Set;

import static java.util.Objects.*;

@Getter
public class Employee {
    int id; // уникальный идентификатор сотрудника;
    String name; // имя сотрудника;
    Set<String> skills; // набор навыков сотрудника.

    public Employee(int id, String name, Set<String> skills) {
        this.id = id;
        this.name = requireNonNull(name);
        this.skills = Set.copyOf(skills);
    }

    @Override
    public String toString() {
        return "Employee{" + id + ", " + name + ", skills=" + skills + "}";
    }
}
