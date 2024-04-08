package BJS2_4952;

public class Main {
    public static void main(String[] args) {
        Hero Christian = new Hero("Christian", "Horde", 540, 5);
        Hero Edric = new Hero("Edric", "Alliance", 840, 4);
        Christian.addCreature(new Swordman("Swordman", 2), 2);
        Christian.addCreature(new Pikeman("Pikeman", 10), 1);
        Edric.addCreature(new Angel("Angel", 4), 4);
        Edric.addCreature(new Griffin("Griffin", 6), 7);
        Battlefield battlefield = new Battlefield(Christian, Edric);
        System.out.println("Победу одержал " + battlefield.battle().getName());
    }
}
