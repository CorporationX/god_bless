package school.faang;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class TwitterAccount {
    private final String username;
    private int followers;
}
