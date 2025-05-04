package school.faang.bjs2_74679;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Player {
    private final String name;
    private int level = 1;
    private AtomicInteger experience = new AtomicInteger(0);
}
