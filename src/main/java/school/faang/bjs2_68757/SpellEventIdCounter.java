package school.faang.bjs2_68757;

import java.util.concurrent.atomic.AtomicInteger;


public class SpellEventIdCounter {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger();



    public static long getNextSpellEventId() {
        return 1L;
    }
}
