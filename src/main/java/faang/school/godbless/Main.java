package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        Character attacker = new Warrior("War");
        Character defender = new Archer("Arch");
        attacker.attack(defender);
        System.out.println(defender.health);
    }
}
