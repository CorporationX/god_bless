package faang.school.godbless.twitter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TwitterAccount {
    private final String username;
    private int followers;
}
