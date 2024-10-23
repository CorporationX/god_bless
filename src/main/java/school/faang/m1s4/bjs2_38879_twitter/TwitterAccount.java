package school.faang.m1s4.bjs2_38879_twitter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Getter
@Setter
public class TwitterAccount {
    private final String username;
    private AtomicInteger followers = new AtomicInteger(0);
}
