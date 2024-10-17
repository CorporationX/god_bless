package school.BJS2_37091;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {

    private String name;
    private int helth;
    private int score;

    public String getName() {
        return name;
    }

    public void uppScore() {
        score++;
    }

    public void downHelth() {
        helth--;
    }

    public boolean checkLife() {
        if (helth == 0) {
            return true;
        } else return false;
    }
}
