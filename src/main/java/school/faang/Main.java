package school.faang;

public class Main {
    public static void main(String[] args) {
        // Задача Абстракция Абстракция
        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        System.out.printf("Параметры варвара: %s \n", warrior);
        System.out.printf("Параметры лучника: %s \n", archer);

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(warrior);
        System.out.println(archer);
        
        // Задача Развернитесь
        User ivan = new User("Ivan", 22, "Uber", "London");
        try {
            User kid = new User("Matthew", 16, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.printf("Вывод данных пользователя: %s \n", ivan);
    }
}
