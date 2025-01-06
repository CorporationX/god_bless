package school.faang.task51021twitter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Getter
@Setter
public class TwitterAccount {
    private final String userName;
    AtomicInteger followers = new AtomicInteger(0);
}
