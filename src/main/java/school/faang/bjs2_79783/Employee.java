package school.faang.bjs2_79783;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
public class Employee {

    private int id;
    private String name;
    private Set<String> skills = new HashSet<>();
    private Set<Project> projects = new HashSet<>();
}
