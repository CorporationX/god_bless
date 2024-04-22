package faang.school.godbless.become_celebrity_in_twitter;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
public class TwitterAccount {
    private String username;
    private AtomicInteger followers;
}