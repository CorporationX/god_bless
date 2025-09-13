package school.faang.sprint1.task1;

public class Example {
	public static void reverse(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		System.out.print("Before: ");
		for (int n : nums) {
			System.out.print(n + " ");
		}
		System.out.println();
		reverse(nums);
		System.out.print("After:  ");
		for (int n : nums) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}
