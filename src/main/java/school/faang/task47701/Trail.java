package school.faang.task47701;

public class Trail implements Runnable {
    private final String knaightName;
    private final String trailName;

    public Trail(String knaightName, String trailName) {
        this.knaightName = knaightName;
        this.trailName = trailName;
    }

    @Override
    public void run() {
        try {
            System.out.println(knaightName + "начинает испытание  " + trailName);
            Thread.sleep(2000);
            System.out.println(knaightName + "завершил испытание  " + trailName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
