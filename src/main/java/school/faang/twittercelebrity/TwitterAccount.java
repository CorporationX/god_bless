package school.faang.twittercelebrity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@RequiredArgsConstructor
public class TwitterAccount {
    private final String username;
    private final AtomicInteger followers = new AtomicInteger();
}
