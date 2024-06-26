package faang.school.godbless.Sprint_1.JavaBeisic.BJS2_7740;

//1. Создать абстрактный класс Character со следующими полями:
//Имя;
//Сила;
//Ловкость;
//Интеллект;
//Здоровье. У всех персонажей по умолчанию 100.
//        2. Сделать в Character два конструктора: один принимает только имя, а другой все доступные параметры,
//кроме здоровья — оно имеет значение по умолчанию.
//3. Создать классы-наследники от Character: Warrior и Archer. Переопределить их конструкторы:
//для Warrior сила всегда выставляется в 10, ловкость в 5, интеллект в 3. Имя передаётся извне;
//для Archer сила всегда выставляется в 3, ловкость в 10, интеллект в 5. Имя передаётся извне.
//4. Сделать в Character абстрактный метод attack, который принимает другого Character в качестве параметра.
//5. Переопределить этот метод в Warrior и Archer:
//в Warriorперсонаж наносит урон противнику в количестве собственной силы. У противника отнимается столько же
//        очков здоровья, сколько он получает урона;
//в Archer персонаж наносит урон противнику в количестве собственной ловкости. У противника отнимается столько
//же очков здоровья, сколько он получает урона.

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");

        System.out.println("Initial Health of " + warrior.getName() + ": " + warrior.getHealth());
        System.out.println("Initial Health of " + archer.getName() + ": " + archer.getHealth());

        warrior.attack(archer);
        System.out.println("Health of " + archer.getName() + " after attack: " + archer.getHealth());

        archer.attack(warrior);
        System.out.println("Health of " + warrior.getName() + " after attack: " + warrior.getHealth());
    }
}
