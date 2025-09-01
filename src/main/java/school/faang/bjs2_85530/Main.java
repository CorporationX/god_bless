package school.faang.bjs2_85530;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] massiveIntNumber = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(reverseMassive(massiveIntNumber)));
    }

    public static int[] reverseMassive(int[] masTemp) {
        int[] reverseMas = new int[masTemp.length];
        for (int i = masTemp.length - 1; i >= 0; i--) {
            reverseMas[masTemp.length - i - 1] = masTemp[i];
        }
        return reverseMas;
    }

}