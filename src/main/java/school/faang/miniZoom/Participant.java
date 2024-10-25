package school.faang.miniZoom;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Participant implements Runnable{
    private final String name;
    private final Conference conference;

    @Override
    public void run() {
        try {
            System.out.println(name + " has joined the conference.");
            conference.getLatch().countDown();
            conference.getLatch().await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
