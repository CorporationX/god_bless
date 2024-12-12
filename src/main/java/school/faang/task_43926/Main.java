package school.faang.task_43926;

public class Main {
    public static void main(String[] args) {
        Warrior archer = new Warrior("Sergey");
        Archer warrior = new Archer("Dmitriy");
        System.out.println("Health archer before attack: " + archer.getHealth());
        archer.attack(warrior);
        System.out.println("Health archer after attack: " + archer.getHealth());
        System.out.println("Health warrior before attack: " + warrior.getHealth());
        warrior.attack(warrior);
        System.out.println("Health warrior after attack: " + warrior.getHealth());

    }

}
