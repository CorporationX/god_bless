package faang.school.godbless.sprint2;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        Example.reverse(array);
        for (int i = 0; i < array.length; ++i)
            System.out.print(array[i] + " ");
    }
}
