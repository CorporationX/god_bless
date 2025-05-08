package school.faang.turnaround;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        int[] arr = {1, 2, 3, 4, 5};
        example.reverse(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
