package faang.school.godbless.BJS2_23480;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Джейми Ланнистер");
        knight1.addTrial(new Trial(knight1.getName(), "Битва на мечах"));
        knight1.addTrial(new Trial(knight1.getName(), "Конкур"));

        Knight knight2 = new Knight("Эддард Старк");
        knight2.addTrial(new Trial(knight2.getName(), "Битва на мечах"));
        knight2.addTrial(new Trial(knight2.getName(), "Конкур"));

        knight1.startTrials();
        knight2.startTrials();
    }
}
