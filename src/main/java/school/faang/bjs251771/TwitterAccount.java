package school.faang.bjs251771;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TwitterAccount {
    private String username;
    private volatile int followers;
}
