package faang.school.godbless;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Creature, Integer> fistArmy = new HashMap<>() {{
            put(new Pikeman(), 6);
            put(new Griffin(), 2);
            put(new Swordman(), 2);
        }};

        HashMap<Creature, Integer> secondArmy = new HashMap<>() {{
            put(new Pikeman(), 2);
            put(new Griffin(), 3);
            put(new Angel(), 3);
        }};

        Hero firstHero = new Hero("Alexander", "Greek", 4, 2, fistArmy);
        Hero secondHero = new Hero("Darius", "Persian", 5, 3, secondArmy);

        Battlefield battleOfGaugamela = new Battlefield(firstHero, secondHero);
        System.out.println(battleOfGaugamela.battle());
    }
}
