package school.faang.twitter;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class TwitterAccount {
    private final String username;
    private int followers;

    public synchronized void addFollower() {
        followers++;
    }
}
