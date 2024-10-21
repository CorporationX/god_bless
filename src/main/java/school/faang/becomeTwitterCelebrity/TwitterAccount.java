package school.faang.becomeTwitterCelebrity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class TwitterAccount {
    private final String username;
    private int followers = 0;

    public void incrementFollowers() {
        followers++;
    }
}
