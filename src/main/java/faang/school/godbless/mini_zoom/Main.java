package faang.school.godbless.mini_zoom;

public class Main {
    public static void main(String[] args) {
        Conference conference = new Conference(5);
        Participant[] participants = new Participant[conference.getRequiredParticipants()];

        for (int i = 0; i < conference.getRequiredParticipants(); i++) {
            participants[i] = new Participant(conference, i + 1);
            participants[i].start();
        }
    }
}
