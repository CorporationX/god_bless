package school.faang.bjs2_36902;

public class BossManager {
    private static Boss bossInstance;


    public static Boss getBossInstance() {
        if (bossInstance == null) {
            bossInstance = new Boss(3);
        }
        return bossInstance;
    }
}