package faang.school.godbless;

public class Example {
    int[] reverse(int array[]) {
        int reversedArray[] = new int[array.length];
        for (int index = array.length - 1, reversedIndex = 0; index >= 0; index--, reversedIndex++) {
            reversedArray[reversedIndex] = array[index];
        }
        for (int i : reversedArray)
            System.out.println(i);
        return reversedArray;
    }

    public static void main(String[] args) {
        Example d = new Example();
        System.out.println(d.reverse(new int[]{1, 2, 3, 4, 5}));
        System.out.println(d.reverse(new int[]{23, -17, 85,32, 7444}));
    }
}
