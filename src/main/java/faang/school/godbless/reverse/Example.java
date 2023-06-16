package faang.school.godbless.reverse;

public class Example {
    public static int[] reverse(int[] array) {

        var i = 0;
        var j = array.length - 1;

        while (i < j) {
            var tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++; j--;
        }

        return array;
    }
}
