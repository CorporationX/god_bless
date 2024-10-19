package school.faang.godbless.bjs2_37128;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Player {
    private final int id;
    private String name;
    private int lives;
    private int score = 0;

    public Player(int id, String name, int lives) {
        this.id = id;
        this.name = name;
        this.lives = lives;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return id == player.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
