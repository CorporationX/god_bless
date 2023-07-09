package faang.school.godbless.thread.tournament;

public enum Result {
    SUCCESS("SUCCESS"),
    DRAW("DRAW"),
    LOSE("LOSE");

    public final String name;

    Result(String name) {
        this.name = name;
    }
}
