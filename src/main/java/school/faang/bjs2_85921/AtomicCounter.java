package school.faang.bjs2_85921;

import lombok.Getter;

@Getter
public class AtomicCounter {
    private static final int DEFAULT_ID = 0;
    private int id = DEFAULT_ID;

    public int incrementId() {
        id++;
        return id;
    }
}
