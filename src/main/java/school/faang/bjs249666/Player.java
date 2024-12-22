package school.faang.bjs249666;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Player {
    private final String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }
}
