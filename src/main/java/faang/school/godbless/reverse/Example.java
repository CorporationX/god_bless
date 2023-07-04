import java.util.ArrayList;
import java.util.List;

public class Example {
    public static List<Integer> reverse(List<Integer> nums){
        List<Integer> reverse = new ArrayList<>();
        for(int i = nums.size()-1; 0 <= i; i--){
            reverse.add(nums.get(i));
        }
        return reverse;
    }
}
