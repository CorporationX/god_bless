package faang.school.godbless.BJS24479;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Воин");
        Archer archer = new Archer("Лучник");

        // Первая атака по 10
        fight(warrior, archer);

        //Воин прокачался +1 сила
        warrior.setStrength(warrior.getStrength() + 1);

        //Лучник прокачался +2 ловкости
        archer.setDexterity(archer.getDexterity() + 2);

        // Вторая атака по 11, 12 и 10 соответственно
        fight(warrior, archer);
    }

    private static void fight(Warrior warrior, Archer archer) {
        warrior.attack(archer);
        archer.attack(warrior);

        // Проверка изменения здоровья
        System.out.println("Здоровье воина: " + warrior.getHealth());
        System.out.println("Здоровье лучника: " + archer.getHealth());
        System.out.println("-------------------------------------------");
    }
}
