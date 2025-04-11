package school.faang.catchevents;

public class AtomicInteger {
    private static int id = 0;

    public static int getId() {
        return id++;
    }
}
