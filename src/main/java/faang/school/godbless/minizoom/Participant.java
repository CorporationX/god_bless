package faang.school.godbless.minizoom;

public record Participant(String name) {
    public void joinConference(Conference conference) {
        conference.addParticipant(this);
    }
}