package school.faang.becomingatwittercelebrity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TwitterAccount {
    private final String userName;
    private int followers;
}
