package school.faang.sprint4.task_63111.resources;

import java.util.ArrayList;
import java.util.List;

public class Resources {
    private final List<String> files = new ArrayList<>();

    protected Resources() {}

    public void write(String file) {
        files.add(file);
    }

    public String read() {
        return files.get(0);
    }
}
