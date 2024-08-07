package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        Character warrior = new Warrior("Gimly");
        Character archer = new Archer("Legolas");

        System.out.println(warrior + "\n" + archer);

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(warrior + "\n" + archer);


    }
}