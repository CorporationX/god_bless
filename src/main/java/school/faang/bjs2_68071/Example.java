package school.faang.bjs2_68071;

class Example {
    private Example() {
        //для предотвращения создание экземпляра класса
    }

    public static int[] reverse(int[] array) {
        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }
        return reversedArray;
    }
}
