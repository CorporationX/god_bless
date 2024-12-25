package school.faang.task_51060;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
@ToString
public class TwitterAccount {
    private final String username;
    private final AtomicInteger followersCount = new AtomicInteger(0);
}
