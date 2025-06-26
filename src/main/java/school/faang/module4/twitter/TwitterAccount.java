package school.faang.module4.twitter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TwitterAccount {
    private String username;
    private int followers;

    public void addFollower() {
        followers++;
    }
}
