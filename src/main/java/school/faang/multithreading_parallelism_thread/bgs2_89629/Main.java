package school.faang.multithreading_parallelism_thread.bgs2_89629;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad archers = new Squad("Лучники", List.of(new Archer(25), new Archer(30)));
        Squad swordsmen = new Squad("Мечники", List.of(new Swordsman(40), new Swordsman(35)));
        Squad mages = new Squad("Маги", List.of(new Mage(50), new Mage(45)));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        Optional<Integer> totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + (totalPower.isPresent()
                ? totalPower.get()
                : "сила отсутствует, так как "));
    }
}