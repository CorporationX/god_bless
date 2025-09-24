package school.faang.bjs2_92958;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Slf4j
public class TwitterAccount {
    private final String username;
    private int followers;
}
