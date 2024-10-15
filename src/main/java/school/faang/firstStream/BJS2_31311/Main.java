package school.faang.firstStream.BJS2_31311;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Zilong");
        Character archer = new Archer("Legolas");

        //Для проверки здоровье лучника до атаки
        System.out.println(archer.getHp());

        warrior.attack(archer);

        //здоровье лучника после атаки
        System.out.println(archer.getHp());

        //здоровье воина до атаки
        System.out.println(warrior.getHp());

        archer.attack(warrior);

        //здоровье воина после атаки
        System.out.println(warrior.getHp());
    }
}
