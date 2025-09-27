package bjs2_89586;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        King king = new King();

        Knight knight1 = new Knight("Добрыня Никитич");
        Knight knight2 = new Knight("Илья Муромец");

        king.addKnightWithTrials(knight1, List.of(
                new Trial(knight1.getName(), "Сражение со Змеем Горынычем"),
                new Trial(knight1.getName(), "Поединок с Кощеем Бессмертным")
        ));

        king.addKnightWithTrials(knight2, List.of(
                new Trial(knight2.getName(), "Поймать Соловья-разбойника"),
                new Trial(knight2.getName(), "Найти то, неведомо что")
        ));

        king.startTournament();
    }
}
