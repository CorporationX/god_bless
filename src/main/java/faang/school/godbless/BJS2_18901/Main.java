package faang.school.godbless.BJS2_18901;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Hero attacker = new Hero("Maximus", "Gold", 1000, 35, new HashMap<>());
        Hero defender = new Hero("Achilles", "Silver", 1000, 45, new HashMap<>());

        attacker.addCreature(new Pikeman(), 1);
        defender.addCreature(new Angel(), 2);
        attacker.addCreature(new Griffin(), 2);

        Battlefield battlefield = new Battlefield(attacker, defender);
        battlefield.battle();
    }
}
