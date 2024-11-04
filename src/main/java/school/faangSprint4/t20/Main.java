package school.faangSprint4.t20;

public class Main {
    public static void main(String[] args) {
        int requiredParticipants = 5;
        Conference conference = new Conference(requiredParticipants);

        System.out.println("Создана конференция, ожидаем " + requiredParticipants + " участников\n");

        for (int i = 1; i <= requiredParticipants; i++) {
            Participant participant = new Participant("Участник " + i, conference);
            new Thread(participant).start();
        }
    }
}