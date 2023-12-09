package faang.school.godbless.hashmap.mightandmagic;

import faang.school.godbless.hashmap.mightandmagic.creatures.Angel;
import faang.school.godbless.hashmap.mightandmagic.creatures.Griffin;
import faang.school.godbless.hashmap.mightandmagic.creatures.Pikeman;
import faang.school.godbless.hashmap.mightandmagic.creatures.Swordman;

public class MightAndMagicApp {

    public static void main(String[] args) {
        Hero garrosh = new Hero("Garrosh", "Horde", 100, 1);
        garrosh.addCreatures(new Pikeman(10), new Angel(3), new Griffin(5));
        
        Hero sylvanas = new Hero("Sylvanas", "Horde", 100, 1);
        sylvanas.addCreatures(new Pikeman(15), new Swordman(3), new Griffin(5));

        Hero winner = new Battlefield().battle(garrosh, sylvanas);
        System.out.println(winner);
    }

}
