package faang.school.godbless.BJS2_18923;

import faang.school.godbless.BJS2_18923.creatures.Angel;
import faang.school.godbless.BJS2_18923.creatures.Griffin;
import faang.school.godbless.BJS2_18923.creatures.Pikeman;
import faang.school.godbless.BJS2_18923.creatures.Swordman;

public class Main {
    public static void main(String[] args) {
        Hero artas = new Hero("Артас", "Люди", 5, 4);
        Hero djaina = new Hero("Джайнра", "Эльфы", 7, 6);

        artas.addCreature(new Angel("Падший ангел"), 3);
        artas.addCreature(new Pikeman("Тесак"), 5);
        artas.addCreature(new Griffin("Змей горыныч"), 3);
        djaina.addCreature(new Angel("Ветрокрыл"), 5);
        djaina.addCreature(new Swordman("Лесоруб"),10);

        Battlefield battlefield = new Battlefield(artas, djaina);
        battlefield.battle();
    }
}
