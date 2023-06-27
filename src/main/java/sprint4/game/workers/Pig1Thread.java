package sprint4.game.workers;

import sprint4.game.Material;

public class Pig1Thread extends PigThread {
    public Pig1Thread(String pigName) {
        super(pigName, Material.STRAW, 20);
    }
}
