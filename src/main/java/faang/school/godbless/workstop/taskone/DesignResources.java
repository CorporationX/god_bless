package faang.school.godbless.workstop.taskone;

import java.util.ArrayList;
import java.util.List;

public class DesignResources {

    private final List<String> FILES = new ArrayList<>();
    private final List<String> NAMES = new ArrayList<>();

    public List<String> getNames() {
        synchronized (NAMES) {
            return NAMES;
        }
    }

    public void addName(String name) {
        validateName(name);
        synchronized (NAMES) {
            NAMES.add(name);
        }
    }

    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name can't be null");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
    }
}
