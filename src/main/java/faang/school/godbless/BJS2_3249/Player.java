package faang.school.godbless.BJS2_3249;

import lombok.Data;
import lombok.NonNull;

@Data
public class Player {
    @NonNull
    private String name;
    @NonNull
    private Integer lives;

    public void kill() {
        lives--;
    }

    public boolean isAlive(){
        return lives > 0;
    }
}

