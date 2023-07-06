package faang.school.godbless.TwitterCelebrity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
@Setter
public class TwitterAccount {
    private String username;
    private int followers;
}
