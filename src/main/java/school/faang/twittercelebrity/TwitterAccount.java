package school.faang.twittercelebrity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TwitterAccount {

    private final String username;
    private int followers;

    public void addFollower() {
        followers++;
    }
}
