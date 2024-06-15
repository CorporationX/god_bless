package faang.school.godbless.razvernites;

class Example {
    static void reverse(int[] array) {
        int[] reversedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int numberMassiv = 0;

            numberMassiv = array[(array.length - 1 - i)];
            reversedArray[i] = numberMassiv;

            System.out.println(numberMassiv);
        }
    }
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7};
        reverse(num);
    }
}