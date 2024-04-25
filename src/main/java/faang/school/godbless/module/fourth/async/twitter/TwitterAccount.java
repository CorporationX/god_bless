package faang.school.godbless.module.fourth.async.twitter;

import lombok.Data;

@Data
public class TwitterAccount {
    private String username;
    private int followers;
    
    public TwitterAccount(String username) {
        this.username = username;
    }
    
    public void addFolower() {
        this.followers++;
    }
}
