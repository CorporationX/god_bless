package school.faang.task_43627;

public class Main {

    public static void main(String[] args) {
        int[] evenExample = {5, 4, 3, 2, 1};
        int[] oddExample = {4, 3, 2, 1};

        printArray(evenExample);
        printArray(Example.reverse(evenExample));

        printArray(oddExample);
        printArray(Example.reverse(oddExample));
    }

    private static void printArray(int[] reverse) {
        for (int i : reverse) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
