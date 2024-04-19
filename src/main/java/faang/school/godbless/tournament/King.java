package faang.school.godbless.tournament;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("сир Ланцелот");
        knight1.addTrial(new Trial("сир Ланцелот", "Убить дракона"));
        knight1.addTrial(new Trial("сир Ланцелот", "Спасти принцессу"));

        Knight knight2 = new Knight("сир Галахад");
        knight2.addTrial(new Trial("сир Галахад", "Найти выход из лабиринта"));
        knight2.addTrial(new Trial("сир Галахад", "Победить минотавра"));

        knight1.startTrials();
        knight2.startTrials();
    }
}
