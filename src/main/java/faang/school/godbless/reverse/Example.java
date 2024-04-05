package faang.school.godbless.reverse;

class Example {
    public int[] reverse(int[] nums) {
        int size = nums.length;
        int[] reversed = new int[size];
        for (int i = 0; i < size; i++) {
            reversed[size - i -1] = nums[i];
        }
        return reversed;
    }
}
