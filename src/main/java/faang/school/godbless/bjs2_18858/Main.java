package faang.school.godbless.bjs2_18858;

public class Main {
    public static void main(String[] args) {
        // odd
        int[] arr = new int[]{1, 2, 3, 4, 5};
        Example.reverse1(arr);
        for (int e : arr) {
            System.out.println(e);
        }
        System.out.println("----");
        Example.reverse2(arr);
        for (int e : arr) {
            System.out.println(e);
        }

        System.out.println("----------------");

        // even
        int[] arrr = new int[]{1, 2, 3, 4, 5, 6};
        Example.reverse1(arrr);
        for (int e : arrr) {
            System.out.println(e);
        }
        System.out.println("----");
        Example.reverse2(arrr);
        for (int e : arrr) {
            System.out.println(e);
        }
    }
}
