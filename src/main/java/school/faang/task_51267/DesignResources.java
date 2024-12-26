package school.faang.task_51267;

import lombok.Data;

import java.util.List;

@Data
public class DesignResources {
    private final List<String> files;

    public void printFiles() {
        files.forEach(System.out::println);
    }
}
