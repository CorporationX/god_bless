package sprint_4.sprint_4_1_async_future.celebrityInTwitter_39080;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class TwitterAccount {
    private final String username;
    private int followers;

    public TwitterAccount(String username) {
        this.username = username;
        followers = 0;
    }

    public void addFollowers(){
        followers++;
    }
}
