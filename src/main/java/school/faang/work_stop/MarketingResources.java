package school.faang.work_stop;

import java.util.ArrayList;
import java.util.List;

public class MarketingResources {
    private final List<String> nameFile = new ArrayList<>();

    public synchronized List<String> readeMarketing() {
        return nameFile;
    }

    public synchronized void addFileMarketing(String file) {
        nameFile.add(file);
    }
}
