package school.faang.task_43808;

public class Main {
    public static void main(String[] args) {
        Warrior character1 = new Warrior("Sasha");
        Archer character2 = new Archer("Nikita");
        character2.attack(character1);
        System.out.println(character1.health);
    }
}
