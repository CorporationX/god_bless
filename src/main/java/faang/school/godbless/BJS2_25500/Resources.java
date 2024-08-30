package faang.school.godbless.BJS2_25500;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@AllArgsConstructor
public abstract class Resources {
    private List<String> files;

    protected void writeFile(String file) {
        files.add(file);
    }

    protected String readFile() {
        int index = ThreadLocalRandom.current().nextInt(files.size());
        return files.get(index);
    }

    protected void printFiles() {
        System.out.println(files);
    }
}
