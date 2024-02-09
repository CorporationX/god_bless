package faang.school.godbless.hash_map.Heroes;


public class Main {
    public static void main(String[] args) {
        Hero attacker = new Hero("Kirill", "Красные" , 100, 20);
        Hero defender = new Hero("Yaroslav", "Зеленые" , 200, 17);

        attacker.addCreature(new Griffin(), 35);
        attacker.addCreature(new Swordman(), 23);
        attacker.addCreature(new Pikeman(), 24);

        defender.addCreature(new Swordman(), 25);
        defender.addCreature(new Pikeman(), 100);
        defender.addCreature(new Griffin(), 20);

        System.out.println(defender.getArmy().size());
        System.out.println(attacker.getArmy().size());

        Battlefield battlefield = new Battlefield(attacker, defender);

        Hero winner = battlefield.battle();

        System.out.println("Победитель: " + winner);

    }
}
