package faang.school.godbless.javacore;

public class Example {
    public int[] reverse(int[] arrayInt) {
        int startIndex = 0;
        int endIndex = arrayInt.length - 1;
        int tmpInt;
        while (startIndex + endIndex == arrayInt.length - 1 && startIndex < endIndex) {
            tmpInt = arrayInt[startIndex];
            arrayInt[startIndex] = arrayInt[endIndex];
            arrayInt[endIndex] = tmpInt;
            startIndex++;
            endIndex--;
        }
        return arrayInt;
    }
}