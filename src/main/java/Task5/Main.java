package Task5;

public class Main {
    public static void main(String[] args){
        int[] nums = {5,4,3,2,1};
        nums = Example.reverse(nums);
        for(Integer integer: nums){
            System.out.print(integer);
        }
    }
}
