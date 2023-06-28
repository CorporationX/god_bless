package faang.school.godbless.thread.tournament;

public enum Result {
    SUCCESS("ПОБЕДА"),
    DRAW("НИЧЬЯ"),
    LOSE("ПОРАЖЕНИЕ");

    public final String name;

    Result(String name) {
        this.name = name;
    }
}
