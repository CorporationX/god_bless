package faang.school.godbless.characters;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Ascold");
        Character archer = new Archer("Robbin");

        System.out.println("At the beginning of the battle: " +
                warrior.getName() + " has health=" + warrior.getHealth() + ", " +
                archer.getName() + " has health=" + archer.getHealth() + "."
        );
        System.out.println("Warriors clashed in battle");
        warrior.attack(archer);
        System.out.println("At the and of the battle: " +
                warrior.getName() + " has health=" + warrior.getHealth() + ", " +
                archer.getName() + " has health=" + archer.getHealth() + "."
        );
    }
}
