package celebrity.twitter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@AllArgsConstructor
public class TwitterAccount {
    private final String username;
    private final AtomicLong followers = new AtomicLong(0L);
}
