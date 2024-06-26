package faang.school.godbless.celebrity_twitter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TwitterAccount {
    private String name;
    private int followers;

    public synchronized void incrementFollowers() {
        followers++;
    }
}
