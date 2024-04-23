package faang.school.godbless.TwitterCelebrity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
public class TwitterAccount {
    private String username;
    private AtomicInteger followers;
}
