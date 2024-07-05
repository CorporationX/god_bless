package faang.school.godbless.zoom;

public class Main {
    public static void main(String[] args) {
        int numberOfParticipants = 5;
        Conference conference = new Conference(numberOfParticipants);

        for (int i = 0; i < numberOfParticipants; i++) {
            new Thread(()->new Participant().joinConference(conference));
        }

       conference.startStreaming();
    }
}
