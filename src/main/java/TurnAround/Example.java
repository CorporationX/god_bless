package TurnAround;

public class Example {
    public static int[] reverse (int[] nums){
        int[] answer = new int[nums.length];

        if (nums.length == 0){
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            answer[i] = nums[nums.length - 1 - i];
        }

        return answer;
    }
}
