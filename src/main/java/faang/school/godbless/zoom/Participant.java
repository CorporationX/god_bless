package faang.school.godbless.zoom;

public class Participant {
    private String name;
    public void joinConference(Conference conference) {
        conference.getCountDownLatch().countDown();
        System.out.println(name+" joined conference");
    }
}
