package school.faang.async.twitter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Setter
@Getter
public class TwitterAccount {

    private final String userName;
    private final AtomicInteger followers;
}
