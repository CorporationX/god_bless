package school.faang.sprint4.task_50732;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Getter
public class TwitterAccount {
    private final String username;
    private final AtomicInteger followersCount = new AtomicInteger(0);
}
