package school.faang.sprint_3.task_49241;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Player {
    @NonNull
    private final String name;
    private int lives;

    public void decreaseLives() {
        lives--;
    }

    public void gameOver() {
        System.out.println(name + " has no lives. And left the game");
        Thread.currentThread().interrupt();
    }
}
