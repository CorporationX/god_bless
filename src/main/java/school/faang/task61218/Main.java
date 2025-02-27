package school.faang.task61218;

import lombok.extern.slf4j.Slf4j;
import school.faang.task61218.army.*;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Army army = new Army();

        // Создаём отряды
        Squad archers = new Squad("Лучники", List.of(new Archer(25), new Archer(30)));
        Squad swordsmen = new Squad("Мечники", List.of(new Swordsman(40), new Swordsman(35)));
        Squad mages = new Squad("Маги", List.of(new Mage(50), new Mage(45)));

        // Добавляем отряды в армию
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        // Вычисляем общую силу армии
        int totalPower = army.calculateTotalPower();
        log.info("Общая сила армии: {}", totalPower);
    }
}
