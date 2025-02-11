package school.faang.abstraction;

public class App {
    public static void main(String[] args) {
        // Создаем объекты персонажей
        Warrior warrior = new Warrior("Воин");
        Archer archer = new Archer("Лучник");

        // Выводим начальное состояние персонажей
        System.out.println("Изначальное состояние персонажей:");
        System.out.println(warrior.getName() + " - Здоровье: " + warrior.getHealth());
        System.out.println(archer.getName() + " - Здоровье: " + archer.getHealth());
        System.out.println();

        // Воин атакует лучника
        System.out.println(warrior.getName() + " атакует " + archer.getName());
        warrior.attack(archer);
        System.out.println(archer.getName() + " - Осталось здоровья: " + archer.getHealth());
        System.out.println();

        // Лучник атакует воина
        System.out.println(archer.getName() + " контратакует " + warrior.getName());
        archer.attack(warrior);
        System.out.println(warrior.getName() + " - Осталось здоровья: " + warrior.getHealth());
        System.out.println();

        // Проверка отрицательного здоровья
        System.out.println(archer.getName() + " контратакует " + warrior.getName());
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        System.out.println(warrior.getName() + " - Осталось здоровья: " + warrior.getHealth());
        System.out.println();

        // Финальная проверка здоровья
        System.out.println("Финальное состояние персонажей:");
        System.out.println(warrior.getName() + " - Здоровье: " + warrior.getHealth());
        System.out.println(archer.getName() + " - Здоровье: " + archer.getHealth());
    }
}
