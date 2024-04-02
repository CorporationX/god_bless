package faang.school.godbless.task_12;

public class Main {
    public static void main(String[] args) {
        Hero first = new Hero("Tem", "Vampire", 21);
        first.addCreature(new Swordman("Goga", 12), 3);
        first.addCreature(new Griffin("Gaga", 7), 9);

        Hero second = new Hero("Lampopo", "Trickster", 19);
        second.addCreature(new Angel("Dar", 17), 5);
        second.addCreature(new Pikeman("Jora", 9), 13);

        Battlefield battlefield = new Battlefield(first, second);

        System.out.println(battlefield.battle());

    }
}
