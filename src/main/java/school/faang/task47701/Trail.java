package school.faang.task47701;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trail implements Runnable {
    private final String knaightName;
    private final String trailName;

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
