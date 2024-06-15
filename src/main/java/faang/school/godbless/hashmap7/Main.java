package faang.school.godbless.hashmap7;

public class Main {
    public static void main(String[] args) {
        Hero attacker = new Hero("Attacker", "fraction1", 100, 13);
        Hero defender = new Hero("Defender", "fraction2", 95, 9);
        attacker.addCreature(new Griffin(), 10);
        attacker.addCreature(new Angel(), 2);
        defender.addCreature(new Pikeman(), 1);
        defender.addCreature(new Swordman(), 5);
        Battlefield battlefield = new Battlefield(attacker, defender);
        Hero winner = battlefield.battle();
        System.out.println(winner);
    }
}
