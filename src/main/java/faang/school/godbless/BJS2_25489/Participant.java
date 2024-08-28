package faang.school.godbless.BJS2_25489;

public record Participant(String name) {
    public void joinConference(Conference conference) {
        conference.addParticipant(this);
    }
}
