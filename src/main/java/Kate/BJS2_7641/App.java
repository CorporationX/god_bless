package Kate.BJS2_7641;

public class App {
    public static void main(String[] args) {
        int lngth = 5;
        int[] nums = new int[lngth];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 10);
            System.out.print(nums[i] + " ");
        }
        System.out.print("\n");
        Example.reverse(nums);
    }
}
