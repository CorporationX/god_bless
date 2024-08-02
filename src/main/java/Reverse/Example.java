package Reverse;

public class Example {
    public static void reverse(int[] inputArray)
    {
        for (int start = 0, end = inputArray.length - 1; start < end; start++, end--)
        {
            int temp = inputArray[start];
            inputArray[start] = inputArray[end];
            inputArray[end] = temp;
        }
    }
}
