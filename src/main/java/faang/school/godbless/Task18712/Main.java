package faang.school.godbless.Task18712;

public class Main {

    public static void main(String[] args) {
        Character warrior = new Warrior("Thorin");
        Character archer = new Archer("Dragon");

        // Вывод информации о персонажах
        System.out.println(warrior);
        System.out.println(archer);

        // Взаимодействие персонажей
        warrior.attack(archer);
        archer.attack(warrior);

        // Вывод информации после атаки
        System.out.println(warrior);
        System.out.println(archer);

    }
}
