package bjs2_89586;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        King king = new King();

        Knight firstKknight = new Knight("Добрыня Никитич");
        Knight secondKnight = new Knight("Илья Муромец");

        king.addKnightWithTrials(firstKknight, List.of(
                new Trial(firstKknight.getName(), "Сражение со Змеем Горынычем"),
                new Trial(firstKknight.getName(), "Поединок с Кощеем Бессмертным")
        ));

        king.addKnightWithTrials(secondKnight, List.of(
                new Trial(secondKnight.getName(), "Поймать Соловья-разбойника"),
                new Trial(secondKnight.getName(), "Найти то, неведомо что")
        ));

        king.startTournament();
    }
}
