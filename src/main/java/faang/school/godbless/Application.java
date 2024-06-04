package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello world");
        int[] arr = new int[]{1,2,3,4,5};

        for (int a: Example.reverse(arr)) {
            System.out.println(a);
        }
    }
}