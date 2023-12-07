package core.reverse;

public class Main {
    public static void main(String[] args) {
        int[] array = Example.reverseArray(new int[]{1, 2, 3, 4, 5});
        for (int num : array) {
            System.out.println(num);
        }
    }
}
