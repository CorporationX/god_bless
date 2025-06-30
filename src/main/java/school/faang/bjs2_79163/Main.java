package school.faang.bjs2_79163;

public class Main {
    public static void main(String[] args) {
        Character attacker = new Archer("Стрелок");
        Character defender = new Warrior("Воин");

        attacker.attack(defender);
        attacker.attack(defender);
        attacker.attack(defender);
        defender.attack(attacker);

        System.out.println(attacker);
        System.out.println(defender);
    }
}
