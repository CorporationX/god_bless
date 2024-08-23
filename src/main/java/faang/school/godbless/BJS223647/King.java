package faang.school.godbless.BJS223647;

public class King {
    public static void main(String[] args) {
        // Создаем рыцарей
        Knight knight1 = new Knight("Sir Arthur Dayne");
        Knight knight2 = new Knight("Sir Barristan Selmy");

        // Добавляем испытания рыцарям
        knight1.addTrial(new Trial(knight1.getName(), "Combat with sword"));
        knight1.addTrial(new Trial(knight1.getName(), "Archery competition"));

        knight2.addTrial(new Trial(knight2.getName(), "Knight's tournament"));
        knight2.addTrial(new Trial(knight2.getName(), "Horse riding competition"));

        // Запускаем испытания для каждого рыцаря
        knight1.startTrials();
        knight2.startTrials();
    }
}
