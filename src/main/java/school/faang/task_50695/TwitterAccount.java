package school.faang.task_50695;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
public class TwitterAccount {
    private String username;
    private final AtomicInteger followers = new AtomicInteger(0);
}
