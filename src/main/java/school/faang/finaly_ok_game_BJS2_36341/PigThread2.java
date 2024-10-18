package school.faang.finaly_ok_game_BJS2_36341;

public class PigThread2 extends PigThread {

    public PigThread2(String name, String material) {
        super(name, material);
    }

    @Override
    public void run() {
        int sleepTime = 3000;
        System.out.printf("%s is building house using %s\n"
                , super.getPigName(), super.getMaterial());
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
