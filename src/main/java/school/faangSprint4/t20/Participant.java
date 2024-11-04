package school.faangSprint4.t20;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Participant implements Runnable {
    private final String name;
    private final Conference conference;

    public void joinConference() {
        try {
            System.out.println("Участник " + name + " присоединяется к конференции");
            Thread.sleep((long) (Math.random() * 2000));
            conference.getBarrier().await();
            System.out.println("Участник " + name + " готов к конференции");
        } catch (Exception e) {
            System.out.println("Ошибка при подключении участника " + name + ": " + e.getMessage());
        }
    }

    @Override
    public void run() {
        joinConference();
    }
}