package sprint5.twitter;

import lombok.Data;

@Data
public class TwitterAccount {
    private final String name;
    private long followers = 0;

    public void incrementFollowers() {
        followers++;
    }
}
