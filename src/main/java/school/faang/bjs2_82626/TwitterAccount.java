package school.faang.bjs2_82626;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@RequiredArgsConstructor
public class TwitterAccount {
    private final String username;
    private final AtomicInteger followers = new AtomicInteger(0);
}
