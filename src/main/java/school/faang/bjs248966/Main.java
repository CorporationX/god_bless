package school.faang.bjs248966;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        WeasleyFamily weasleyFamily =
                new WeasleyFamily(Arrays.asList("подмести пол", "помыть посуду", "покормить кота"));
        weasleyFamily.startChores();
    }
}
