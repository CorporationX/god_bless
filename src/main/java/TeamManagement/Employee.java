import lombok.Getter;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.logging.Logger;

@Getter
public class Employee {
    private static final Logger logger = Logger.getLogger(Employee.class.getName());
    private final int id;
    private final String name;
    private final Set<String> skills;
    private int assignedProjects = 0;

    public Employee(int id, String name, Set<String> skills) {
        this.id = id;
        this.name = name;
        this.skills = new HashSet<>(skills);
        logger.info("Created Employee: " + this);
    }

    public void incrementProjects() {
        assignedProjects++;
    }

    public void decrementProjects() {
        assignedProjects = Math.max(0, assignedProjects - 1);
    }

    @Override
    public String toString() {
        return String.format(" Employee {id = %d, name = '%s', skills = %s}", id, name, skills);
    }
}
