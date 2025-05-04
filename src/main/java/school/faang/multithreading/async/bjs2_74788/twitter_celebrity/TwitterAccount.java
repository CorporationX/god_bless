package school.faang.multithreading.async.bjs2_74788.twitter_celebrity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class TwitterAccount {
    private final String username;
    private AtomicInteger followers = new AtomicInteger(0);
}
