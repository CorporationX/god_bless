package school.faang.task_43878;

public class Main {
    public static void main(String[] args) {

        Warrior warrior = new Warrior("ВОИН");
        Archer archer = new Archer("ЛУЧНИК");

        //health at the beginning
        System.out.println(warrior.getName() + " здоровье: " + warrior.getHealth());
        System.out.println(archer.getName() + " здоровье: " + archer.getHealth());

        //ЛУЧНИК атакует ВОИНА
        System.out.println("\n___ВОИН атакует ЛУЧНИКА__");
        archer.attack(warrior);
        System.out.println(warrior.getName() + " здоровье после атаки: " + warrior.getHealth());

        // ВОИН атакует ЛУЧНИКА
        System.out.println("\n__ВОИН атакует ЛУЧНИКА__");
        warrior.attack(archer);
        System.out.println(archer.getName() + " здоровье после атаки: " + archer.getHealth());

        // в случае здоровья меньше нуля (ожидается 0)
        System.out.println("\n__ЛУЧНИК атакует ВОИНА__");
        for (int i = 0; i < 10; i++) {
            archer.attack(warrior);
        }
        System.out.println(warrior.getName() + " здоровье после атаки: " + warrior.getHealth());

        // Проверка здоровья после нескольких атак
        System.out.println("\n__ФИНАЛ__:");
        System.out.println(warrior.getName() + " здоровье: " + warrior.getHealth());
        System.out.println(archer.getName() + " здоровье: " + archer.getHealth());
    }
}
