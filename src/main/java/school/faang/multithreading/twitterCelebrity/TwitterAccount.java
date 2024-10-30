package school.faang.multithreading.twitterCelebrity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TwitterAccount {
    public String username;
    public int followers;

    public void incrementFollowersBy(int num) {
        followers += num;
    }
}
