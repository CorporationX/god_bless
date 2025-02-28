package school.faang.becoming_a_celebrity_on_twitter.BJS2_62552;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class TwitterAccount {
    private final String username;
    private Long followers = 0L;
}
