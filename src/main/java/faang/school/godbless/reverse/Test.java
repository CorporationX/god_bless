package faang.school.godbless.reverse;

public class Test {
    public static void main(String[] args) {
        Example example = new Example();
        int[] arrays = {1, 2, 3, 4, 5};

        int[] rev = example.reveverse(arrays);

        for (int count : arrays) {
            System.out.print(count + " ");
        }

        System.out.println();

        for (int countReverse : rev) {
            System.out.print(countReverse + " ");
        }
    }
}

