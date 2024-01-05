package faang.school.godbless.multithreading.volotileImmutable.miniZoom;

public class MiniZoom {
    private static final int REQUIRED_AMOUNT_PEOPLE = 5;

    public static void main(String[] args) {
        Conference conference = new Conference("Faang School The Best of Schools!");

        System.out.println("Required numbers of participants - " + conference.getBARRIER().getParties());
        for (int i = 0; i < REQUIRED_AMOUNT_PEOPLE; i++) {
            Thread thread = new Thread(new Participant("Participant - " + (i + 1), conference));
            thread.start();
        }
    }
}
