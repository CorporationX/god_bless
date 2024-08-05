package faang.school.godbless.BJS2_18631;

public class Main {

    public static void main(String[] args) {
        Character ork = new Warrior("Дрек’Тар");
        Character elf = new Archer("Эарендил");

        //Орк аттакует эльфа
        System.out.println("Здоровье эльфа: " + elf.getHealth());
        ork.attack(elf);
        System.out.println("Здоровье эльфа: " + elf.getHealth() + "\n");

        //Эльф aттакует орка
        System.out.println("Здоровье орка: " + ork.getHealth());
        elf.attack(ork);
        System.out.println("Здоровье орка: " + ork.getHealth());

    }
}
