package school.faang.m1bjs243617;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 3, 4, 5};
        Example.reverse(array);

        for (int i = 0; i < array.length; i++)
        System.out.print(array[i] + ", ");
    }
}
