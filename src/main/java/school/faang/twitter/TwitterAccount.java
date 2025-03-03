package school.faang.twitter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class TwitterAccount {
    private String username;
    private int followers;
}
