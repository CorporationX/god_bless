package faang.school.godbless.aged777_BSJ2_7758_abstraction;
public class Main {
    /*

    Условия задачи:
    Создать абстрактный класс Character со следующими полями:
    Имя; Сила; Ловкость; Интеллект;
    Здоровье. У всех персонажей по умолчанию 100.
    Сделать в Character два конструктора: один принимает только имя, а другой все доступные параметры,
    кроме здоровья — оно имеет значение по умолчанию. Создать классы-наследники от Character: Warrior и Archer.
    Переопределить их конструкторы: для Warrior сила всегда выставляется в 10, ловкость в 5, интеллект в 3.
    Имя передаётся извне; для Archer сила всегда выставляется в 3, ловкость в 10, интеллект в 5.
    Имя передаётся извне.
    Сделать в Character абстрактный метод attack, который принимает другого Character в качестве параметра.
    Переопределить этот метод в Warrior и Archer:
    в {{Warrior}}персонаж наносит урон противнику в количестве собственной силы. У противника отнимается столько
    же очков здоровья, сколько он получает урона;
    в Archer персонаж наносит урон противнику в количестве собственной ловкости. У противника отнимается столько
    же очков здоровья, сколько он получает урона.

    Замечание: для доступа к полям, нужно добавить им соответствующий модификатор доступа в абстрактном классе.

     */
    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior1");
        Character archer = new Archer("Archer1");

        System.out.println("Состояние персонажей перед битвой:");
        System.out.println(warrior);
        System.out.println(archer);

        System.out.println("\nВоин атакует лучника:");
        warrior.attack(archer);
        System.out.println("Здоровье воина: " + warrior.health);
        System.out.println("Здоровье лучника: " + archer.health);

        System.out.println("\nЛучник атакует воина:");
        archer.attack(warrior);
        System.out.println("Здоровье воина: " + warrior.health);
        System.out.println("Здоровье лучника: " + archer.health);
    }
}
