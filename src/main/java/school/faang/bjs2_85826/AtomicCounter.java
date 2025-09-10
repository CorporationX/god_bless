package school.faang.bjs2_85826;

public class AtomicCounter {
    private static final int ID_DEFAULT = 0;
    private static int id = ID_DEFAULT;

    public static int incrementId() {
        return id++;
    }
}
