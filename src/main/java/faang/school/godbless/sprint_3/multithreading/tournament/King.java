package faang.school.godbless.sprint_3.multithreading.tournament;

public class King {
    public static void main(String[] args) {
        Knight first = new Knight("Artur");
        first.addTrial(new Trial(first.getName(), "Полоса препятствий"));
        first.addTrial(new Trial(first.getName(), "Выносливость"));
        Knight second = new Knight("Ludvik");
        second.addTrial(new Trial(second.getName(), "Бой на мечах"));
        second.addTrial(new Trial(second.getName(), "Борьба с противником"));
        first.startTrials();
        second.startTrials();
    }
}
