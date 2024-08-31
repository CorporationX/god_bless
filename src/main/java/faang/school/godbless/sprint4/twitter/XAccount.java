package faang.school.godbless.sprint4.twitter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class XAccount {
    private final String username;
    private int followers = 0;

    public void incrementFollowers() {
        this.followers++;
    }
}
