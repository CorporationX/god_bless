package school.faang.sprint.third.supercow;

import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Data
@Slf4j
public class Player {
    private final Random rand = new Random();
    @NonNull
    private final String name;

    public Player(@NonNull String name) {
        validateName(name);
        this.name = name;
    }

    public void doBattle(@NonNull Boss boss){
        boss.joinBattle(this);
        try {
            Thread.sleep(rand.nextInt(5000));
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
        boss.leaveBattle(this);
    }

    private void validateName(@NonNull String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }
}
