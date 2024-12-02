package school.faang.task_43614;

public class Main {
    public static void main(String[] args) {

        Example example = new Example();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        example.reverse(nums);
    }
}

class Example {
    public static int[] reverse(int[] array) {

        if (array.length != 0){
            int[] arrayRev = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                arrayRev[i] = array[array.length - 1 - i];
            }
            array = arrayRev;
        }

        return array;
    }
}


