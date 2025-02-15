package school.faang.secretsofdroids;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final String FIRST_MESSAGE = "Hello World!";
    private static final String SECOND_MESSAGE = "I ate the vaccine";
    private static final String THIRD_MESSAGE = "Bye universe";
    private static final int FIRST_KEY = 1;
    private static final int SECOND_KEY = 2;
    private static final int THIRD_KEY = 3;

    public static void main(String[] args) {
        try {
            Droid r2d2 = new Droid("R2D2");
            Droid c3po = new Droid("C3PO");
            Droid bb8 = new Droid("BB-8");

            r2d2.sendMessage(FIRST_MESSAGE, FIRST_KEY, c3po);
            c3po.sendMessage(THIRD_MESSAGE, SECOND_KEY, r2d2);
            bb8.sendMessage(FIRST_MESSAGE, THIRD_KEY, r2d2);
            r2d2.sendMessage(SECOND_MESSAGE, FIRST_KEY, c3po);
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }
}
