package school.faang.turnaround;

public class Example {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        turnAround(array);
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public static void turnAround(int[] array) {
        int temp = 0;
        int temp2 = array.length - 1;
        int temp3;
        for (int i = 0; i < array.length/2; i++) {
            temp3 = array[temp];
            array[temp] = array[temp2];
            array[temp2] = temp3;
            temp++;
            temp2--;
        }
    }
}
