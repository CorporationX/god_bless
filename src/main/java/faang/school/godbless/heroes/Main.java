package faang.school.godbless.heroes;

public class Main {

    public static void main(String[] args) {
        Creature pikeman = new Pikeman();
        Creature griffin = new Griffin();

        Hero varya = new Hero("Varya", "fraction", 1, 1);
        varya.addCreature(pikeman, 1);

        Hero noName = new Hero("NoName", "fraction2", 2, 2);
        noName.addCreature(griffin, 2);

        Battlefield battlefield = new Battlefield(varya, noName);
        System.out.println(battlefield.battle());
    }
}
