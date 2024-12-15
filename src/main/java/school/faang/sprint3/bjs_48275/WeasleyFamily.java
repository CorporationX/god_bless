package school.faang.sprint3.bjs_48275;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = fillingChoresList();
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            Chore task = new Chore(chore);
            executor.submit(task);
        }

        executor.shutdown();
    }

    private static String[] fillingChoresList() {
        String[] chores = new String[10];

        chores[0] = "помыть посуду";
        chores[1] = "подмести пол";
        chores[2] = "пропылесосить";
        chores[3] = "сходить в магазин";
        chores[4] = "вынести мусор";
        chores[5] = "покормить кота";
        chores[6] = "приготовить ужин";
        chores[7] = "заправить постель";
        chores[8] = "погладить белье";
        chores[9] = "поменять лампочку";

        return chores;
    }
}
