package faang.school.godbless.BJS2_25374;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Resources {
    private final List<String> files = new ArrayList<>();
    @Getter
    private final Object writingLock = new Object();
    @Getter
    private final Object readingLock = new Object();

    public void addFile(String file) {
        files.add(file);
    }

    public void viewFiles() {
        files.forEach(System.out::println);
    }
}
