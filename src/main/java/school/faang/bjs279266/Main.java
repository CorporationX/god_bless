package school.faang.bjs279266;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Воин Артур");
        Archer archer = new Archer("Лучник Робин");

        System.out.println("Начальные характеристики:");
        System.out.printf("%s - Здоровье: %d, Сила: %d%n",
                warrior.getName(), warrior.getHealth(), warrior.getStrength());
        System.out.printf("%s - Здоровье: %d, Ловкость: %d%n",
                archer.getName(), archer.getHealth(), archer.getDexterity());

        System.out.println("\nНачинаем бой!");

        int round = 1;
        while (warrior.getHealth() > 0 && archer.getHealth() > 0) {
            System.out.printf("\n--- Раунд %d ---%n", round);

            System.out.printf("%s атакует %s!%n", warrior.getName(), archer.getName());
            warrior.attack(archer);
            System.out.printf("У %s осталось здоровья: %d%n", archer.getName(), archer.getHealth());

            if (archer.getHealth() <= 0) {
                System.out.printf("%s погиб! Победил %s!%n", archer.getName(), warrior.getName());
                break;
            }

            System.out.printf("%s атакует %s!%n", archer.getName(), warrior.getName());
            archer.attack(warrior);
            System.out.printf("У %s осталось здоровья: %d%n", warrior.getName(), warrior.getHealth());

            if (warrior.getHealth() <= 0) {
                System.out.printf("%s погиб! Победил %s!%n", warrior.getName(), archer.getName());
                break;
            }

            round++;

            if (round > 20) {
                System.out.println("Бой затянулся слишком долго. Ничья!");
                break;
            }
        }

        System.out.println("\nИтоговые характеристики:");
        System.out.printf("%s - Здоровье: %d%n", warrior.getName(), warrior.getHealth());
        System.out.printf("%s - Здоровье: %d%n", archer.getName(), archer.getHealth());
    }
}