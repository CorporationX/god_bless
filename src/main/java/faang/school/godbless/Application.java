package faang.school.godbless;


import java.util.HashMap;
import java.util.LinkedHashMap;

public class Application {
    public static void main(String[] args) {
        Hero h1 = new Hero("AA", "Aliance", 10, 1,new LinkedHashMap<>());
        Hero h2 = new Hero("BB", "Orks", 13, 1,new LinkedHashMap<>());
        h1.addCreature(new Pikeman(), 2);
        h1.addCreature(new Griffin(), 2);
        h1.addCreature(new Swordman(), 4);
        h1.addCreature(new Angel(), 5);

        h2.addCreature(new Pikeman(), 4);
        h2.addCreature(new Griffin(), 3);
        h2.addCreature(new Swordman(), 2);
        h2.addCreature(new Angel(), 2);

        Battlifild.battle(h1, h2);




    }
}
