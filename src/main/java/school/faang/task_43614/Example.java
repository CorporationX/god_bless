package school.faang.task_43614;

public class Example {
    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,5};
        reverse(nums);
    }

    public static int[] reverse(int[] array){

        int[] arrayRev = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            arrayRev[i] = array[array.length-1-i];
        }
        array = arrayRev;
        return array;
    }
}

