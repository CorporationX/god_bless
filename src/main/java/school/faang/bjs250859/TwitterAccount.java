package school.faang.bjs250859;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TwitterAccount {
    private final String username;
    private int followers = 0;
}
