package school.faang.sprint4.task50650.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@RequiredArgsConstructor
public class TwitterAccount {
    private final String username;
    private AtomicInteger followers = new AtomicInteger(0);

}
