package school.faang.sprint_1.task_bjs2n43622;

public class Main {
    public static void main(String[] args) {

        Example example = new Example();

        int[] arrayEven = new int[]{1,2,3,4,5,6,7,8};
        int[] arrayOdd = new int[]{1,2,3,4,5,6,7,8,9};
        example.reverse( arrayEven);
        example.reverse( arrayOdd);

        for(int num: arrayEven) {
            System.out.print(num + " ");
        }
        System.out.println();
        for(int num: arrayOdd) {
            System.out.print(num + " ");
        }
    }
}
