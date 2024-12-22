package school.faang.task50663;

import java.util.List;

public record TwitterAccount(String username,
                             List<TwitterAccount> followers) {
}
