package school.faang.godbless.bjs2_39008;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TwitterAccount {
    private String username;
    private int followers;

    public synchronized void incrementFollowers() {
        followers++;
    }
}
