package school.faang.task_43853;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Иван Золо");
        Archer archer = new Archer("Фимоз");

        fight(warrior, archer);
    }

    public static void fight(Character character1, Character character2) {
        do {
            System.out.printf("%s атакует %s и наносит %s урона%n", character1.getName(), character2.getName(), character1.attack(character2));
            if (character2.getHealth() <= 0) break;
            System.out.printf("%s атакует %s и наносит %s урона%n", character2.getName(), character1.getName(), character2.attack(character2));
        } while (character1.getHealth() > 0);

        System.out.println("Победил: " + ((character1.getHealth() > 0)? character1.getName(): character2.getName()));
    }
}
