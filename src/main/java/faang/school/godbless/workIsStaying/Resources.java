package faang.school.godbless.workIsStaying;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Resources {
    protected List<String> files;

    public Resources() {
        files = new CopyOnWriteArrayList<>();
    }

    public void read() {
        System.out.println("reading...");
        for (String s : files) {
            System.out.println("\t" + s);
        }
    }

    public void write() {
        System.out.println("writing...");
        for (int i = 0; i < 100; i++) {
            files.add(i + " ");
        }
    }
}
