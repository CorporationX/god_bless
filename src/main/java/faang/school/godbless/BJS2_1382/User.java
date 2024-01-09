package faang.school.godbless.BJS2_1382;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class User {
    private static final AtomicInteger count = new AtomicInteger(1);
    private final int id;
    @Setter
    private String name;

    public User(String name) {
        this.id = count.getAndIncrement();
        this.name = name;
    }
}