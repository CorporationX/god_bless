package school.faang.twitter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TwitterAccount {
    private String username;
    private int followers;

    public void addFollower() {
        followers++;
    }
}
