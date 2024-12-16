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
        String[] choreList = {
                "помыть посуду",
                "подмести пол",
                "пропылесосить",
                "сходить в магазин",
                "вынести мусор",
                "покормить кота",
                "приготовить ужин",
                "заправить постель",
                "погладить белье",
                "поменять лампочку"
        };

        for (int i = 0; i < chores.length; i++) {
            chores[i] = choreList[i];
        }

        return chores;
    }
}
