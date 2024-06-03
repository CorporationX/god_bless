package faang.school.godbless;

public class Example {
    public int[] reverse(int[] arr){
        for (int start=0,end=arr.length-1;start<=end;start++,end--) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
        return arr;
    }
}
