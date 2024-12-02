package school.faang.task_43502;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("John Snow");
        Character archer = new Archer("Anguy");

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(warrior.getHealth());
        System.out.println(archer.getHealth());
    }
}
