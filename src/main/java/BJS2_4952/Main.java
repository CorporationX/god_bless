package BJS2_4952;

public class Main {
    public static void main(String[] args) {
        Hero Christian = new Hero("Christian", "Horde", 540, 5);
        Hero Edric = new Hero("Edric", "Alliance", 840, 4);

        Christian.addCreature(new Swordman("Swordman", 2), 2);
        Edric.addCreature(new Swordman("Angel", 4), 4);
        Edric.addCreature(new Swordman("Griffin", 6), 7);

        Battlefield battlefield = new Battlefield(Christian, Edric);

        System.out.println(battlefield.battle());
    }
}
