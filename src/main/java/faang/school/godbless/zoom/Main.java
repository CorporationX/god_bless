package faang.school.godbless.zoom;

public class Main {
    public static void main(String[] args) {
        int numberOfParticipants = 5;
        Conference conference = new Conference(numberOfParticipants);

        for (int i = 1; i <= numberOfParticipants; i++) {
            Participant participant = new Participant("Участник " + i, conference);
            Thread participantThread = new Thread(participant);
            participantThread.start();
        }

        try {
            conference.startStreaming();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

