package faang.school.godbless.miniZoom;

public class Main {
    public static void main(String[] args) {
        int requiredParticipants = 5;

        Conference conference = new Conference(requiredParticipants);

        Participant[] participants = new Participant[requiredParticipants];
        for (int i = 0; i < requiredParticipants; i++) {
            participants[i] = new Participant(conference);
            Thread thread = new Thread(participants[i]);
            thread.start();
        }
    }

}
