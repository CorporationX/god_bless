package school.faang.bjs2_82617_twitter_celeb;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TwitterAccount {
    @NonNull
    private final String username;

    //This could have been an AtomicInteger, but it would make task requirement of using a synchronized method useless.
    private int followers;
}
