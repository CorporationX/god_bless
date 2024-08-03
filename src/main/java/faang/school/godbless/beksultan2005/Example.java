package faang.school.godbless.beksultan2005;

public class Example{
    public static int[] reverse(int[] arr){
        for (int i = 0; i < arr.length / 2; i++){
            arr[i] = arr[arr.length - i -1] + arr[i];
            arr[arr.length - i - 1] = arr[i] - arr[arr.length - i -1];
            arr[i] = arr[i] - arr[arr.length - i - 1];
        }
        return arr;
    }
}
