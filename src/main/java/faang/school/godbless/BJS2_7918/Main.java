package faang.school.godbless.BJS2_7918;

public class Main {

    public static void main(String[] args) {

        Hero Zeld = new Hero("Zeld", "fraction1", 51, 64);
        Hero Ognes = new Hero("Ognes", "fraction2", 31, 41);

        Ognes.addCreature(Angel.createCreature(57));
        Ognes.addCreature(Griffin.createCreature(24));
        Ognes.addCreature(Pikeman.createCreature(51));

        Zeld.addCreature(Pikeman.createCreature(21));
        Zeld.addCreature(Angel.createCreature(62));
        Zeld.addCreature(Swordman.createCreature(31));


        Battlefield battlefield = new Battlefield(Zeld, Ognes);

        Hero winner = battlefield.battle();

        System.out.println(winner);
    }
}
