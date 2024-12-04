package school.faang.task_43853;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Иван Золо");
        Archer archer = new Archer("Фимоз");

        fight(warrior, archer);
    }

    public static void fight(Character character1, Character character2) {
        do {
            character1.attack(character2);
            if (!character2.isAlive()) {
                break;
            }
            character2.attack(character1);
        } while (character1.isAlive());

        System.out.println("Победил " + (character1.isAlive() ? character1.getName() : character2.getName()));
    }
}
