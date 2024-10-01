package faang.school.godbless.workIsStaying;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DesignResources {
    @Getter
    private static List<String> files = new CopyOnWriteArrayList<>();

    private DesignResources() {
    }

    public static void init(List<String> files) {
        if (files == null) {
            files = new CopyOnWriteArrayList<>();
        }
        DesignResources.files.addAll(files);
    }

    public static void read() {
        System.out.println("reading design...");
        for (String s : files) {
            System.out.println("\t" + s);
        }
    }

    public static void write() {
        System.out.println("writing design...");
        for (int i = 0; i < 100; i++) {
            files.add(i + " ");
        }
    }
}
