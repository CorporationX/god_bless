package school.faang.task416.twitter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TwitterAccount {
    private String username;
    private int followers;

    public void incrementFollowers() {
        followers++;
    }
}
