package school.faang.sprint4.bjs_50713;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TwitterAccount {
    private String userName;
    private volatile int followers;

    public synchronized void addFollower() {
        followers++;
    }
}
