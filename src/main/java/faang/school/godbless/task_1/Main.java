package faang.school.godbless.task_1;

public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero("Barbian", "Human");
        Hero h2 = new Hero("Archer", "Elf");
        Creature pikeman = new Pikeman();
        Creature swordman = new Swordman();
        Creature angel = new Angel();
        h1.addCreature(pikeman, 10);
        h1.addCreature(swordman, 7);
        h2.addCreature(angel, 20);
        h2.addCreature(pikeman, 10);
        Battlefield battlefield = new Battlefield(h1, h2);
        System.out.println("The winner is "+battlefield.battle());
        h2.removeCreature(pikeman, 3);
        System.out.println("The winner is "+battlefield.battle());
    }
}
