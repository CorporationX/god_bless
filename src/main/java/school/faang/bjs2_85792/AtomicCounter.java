package school.faang.bjs2_85792;

public class AtomicCounter {
    private static final int DEFAULT_ID = 0;
    private int id = DEFAULT_ID;

    public int incrementId() {
        id++;
        return id;
    }

}
