package faang.school.godbless.module.hashmap.heroes;

import faang.school.godbless.module.hashmap.heroes.creature.Angel;
import faang.school.godbless.module.hashmap.heroes.creature.Griffin;
import faang.school.godbless.module.hashmap.heroes.creature.Pikeman;
import faang.school.godbless.module.hashmap.heroes.creature.Swordman;
import faang.school.godbless.module.hashmap.heroes.hero.FirstPlayer;
import faang.school.godbless.module.hashmap.heroes.hero.Hero;

public class Main {
    public static void main(String[] args) {
        FirstPlayer firstPlayer = new FirstPlayer("Booba", "Alliaince");
        FirstPlayer secondPlayer = new FirstPlayer("Gooba", "Horde");
        firstPlayer.addCreature(new Angel(),4);
        firstPlayer.addCreature(new Griffin(), 2);
        secondPlayer.addCreature(new Pikeman(), 3);
        secondPlayer.addCreature(new Swordman(), 6);
        Battlefield battlefield = new Battlefield(firstPlayer, secondPlayer);
        
        Hero winner = battlefield.battle();
        System.out.printf("Выиграл игрок: %s", winner.getName());
    }
}
