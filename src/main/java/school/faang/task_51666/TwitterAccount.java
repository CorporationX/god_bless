package school.faang.task_51666;


import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@ToString
public class TwitterAccount {
    private String userName;
    private int followers = 0;

    public TwitterAccount(String userName) {
        if (userName.isEmpty()) {
            throw new IllegalArgumentException("UserName cannot be empty");
        }
        this.userName = userName;
    }

    public void addFollower() {
        this.followers++;
    }
}
