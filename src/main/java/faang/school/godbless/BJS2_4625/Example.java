package faang.school.godbless.BJS2_4625;

public class Example {
    static public int[] reverse(int[] integerList) {
        for (int i = 0; i < integerList.length / 2; i++) {
            int temp = integerList[i];
            integerList[i] = integerList[integerList.length - i - 1];
            integerList[integerList.length - i - 1] = temp;
        }

        return integerList;
    }
}
