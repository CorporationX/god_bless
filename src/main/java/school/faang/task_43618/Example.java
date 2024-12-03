package school.faang.task_43618;

public class Example {
    public void reverse (int []arr){
        for(int i = arr.length - 1; i >= 0; i--){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        Example example = new Example();
        example.reverse(array);
    }
}
