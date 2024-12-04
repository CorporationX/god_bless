package school.faang.task_43869;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Воин");
        Character archer = new Archer("Лучник");

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(archer.getName() + "\n здоровье: " + archer.getHealth());
        System.out.println(warrior.getName() + "\n здоровье: " + warrior.getHealth());
    }
}
