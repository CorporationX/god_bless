package were_nice_but_extremely_poor;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        WeasleyFamily weasleyFamily = new WeasleyFamily();

        Arrays.stream(weasleyFamily.chore).forEach(chore -> weasleyFamily.executor.submit(new Chore(chore)));
        weasleyFamily.executor.shutdown();
    }
}
