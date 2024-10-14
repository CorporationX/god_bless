package school.BJS2_35851;

import lombok.Getter;

@Getter
public class PowerArmy implements Runnable {

    private Character character;
    private int power;


    public PowerArmy(Character character) {
        this.character = character;
    }

    public void run() {
        this.power = character.getPower();
    }

}
