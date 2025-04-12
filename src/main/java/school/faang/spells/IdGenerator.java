package school.faang.spells;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    @Getter
    private static AtomicInteger id = new AtomicInteger();

}
