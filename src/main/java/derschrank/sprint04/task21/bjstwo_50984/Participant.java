package derschrank.sprint04.task21.bjstwo_50984;

public record Participant(
        String name
) {
    public void joinConference(Conference conference) {
        System.out.printf(" . Participant: %s is waiting on conference...%n", name);
        conference.join();
        System.out.printf(" ! Participant: %s is on conference!!!%n", name);
    }
}
