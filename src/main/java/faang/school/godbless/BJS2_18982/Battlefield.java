package faang.school.godbless.BJS2_18982;

public class Battlefield {
    public static void main(String[] args) {
        // Герои
        Hero knight = new Hero("Arthur", "People", 100, 30);
        Hero fiend = new Hero("Nightmare", "Demon", 100, 30);

        // Существа
        Pikeman pikeman = new Pikeman();
        Griffin griffin = new Griffin();
        Swordman swordman = new Swordman();
        Angel angel = new Angel();

        //Добавление существ в армию героев
        knight.addCreature(pikeman, 3);
        knight.addCreature(swordman, 3);
        knight.addCreature(angel, 2);

        fiend.addCreature(pikeman, 2);
        fiend.addCreature(swordman, 2);
        fiend.addCreature(griffin, 3);
    }

    public Hero battle(Hero heroOne, Hero heroTwo) {
        
    }
}
