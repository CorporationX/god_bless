package faang.school.godbless.BJS2_24668;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TwitterAccount {
    private String username;
    private int followers;

    public TwitterAccount(String username) {
        this.username = username;
        followers = 0;
    }

    public void addFollower(){
        followers++;
    }
}
