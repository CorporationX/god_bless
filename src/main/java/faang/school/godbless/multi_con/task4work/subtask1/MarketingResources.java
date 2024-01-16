package faang.school.godbless.multi_con.task4work.subtask1;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MarketingResources {
    private List<String> files = new CopyOnWriteArrayList<>();

    public void addFile(String name) {
        files.add(name);
    }

    public List<String> getFiles() {
        return files;
    }
}
