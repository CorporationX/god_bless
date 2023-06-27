package sprint4.game.workers;

import sprint4.game.Material;

public class Pig2Thread extends PigThread {
    public Pig2Thread(String pigName) {
        super(pigName, Material.STICKS, 10);
    }
}
