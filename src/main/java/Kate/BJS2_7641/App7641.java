package Kate.BJS2_7641;

public class App7641 {
    public static void main(String[] args) {
        int lngth = 5;
        int[] nums = new int[lngth];
        for(int i = 0; i<nums.length;i++) {
            nums[i] = (int) (Math.random()*10);
            System.out.print(nums[i] + " ");
        }
        System.out.print("\n");
        //Example.reverse(nums, lngth);
        for(int i = 0; i < (Example.reverse(nums, lngth).length) ; i++) {
            System.out.print((Example.reverse(nums, lngth))[i] + " ");
        }
    }
}
