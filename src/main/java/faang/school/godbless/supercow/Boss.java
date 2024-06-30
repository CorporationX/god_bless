package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
@AllArgsConstructor
public class Boss {
    private int maxPlayers;
    private List<Player> currentPlayers;
}
