package school.faang.bjs2_85621;

import school.faang.bjs2_85621.Character.Arching;
import school.faang.bjs2_85621.Character.Warrior;

public class Main {
    public static void main(String[] args) {
        Warrior war1 = new Warrior("Leha");
        Arching opponent1 = new Arching("Vanya");
        war1.attack(opponent1);
        System.out.println(opponent1.getHealth());

        Arching arc1 = new Arching("Petya");
        Warrior opponent2 = new Warrior("Vika");
        arc1.attack(opponent2);
        System.out.println(opponent2.getHealth());
    }

}
