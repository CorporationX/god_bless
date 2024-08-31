package faang.school.godbless.workIsStaying;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MarketingResources {
    @Getter
    private static final List<String> files = new CopyOnWriteArrayList<>();
    private MarketingResources() {}

    public static void init(List<String> files) {
        MarketingResources.files.addAll(files);
    }

    public static void read() {
        System.out.println("reading marketing...");
        for (String s : files) {
            System.out.println("\t" + s);
        }
    }

    public static void write() {
        System.out.println("writing marketing...");
        for (int i = 0; i < 100; i++) {
            files.add(i + " ");
        }
    }

}
