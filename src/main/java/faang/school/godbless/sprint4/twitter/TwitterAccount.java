package faang.school.godbless.sprint4.twitter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class TwitterAccount {
    private final String username;
    @Setter
    private int followers;
}
