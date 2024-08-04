package BJS218595;

import lombok.ToString;

@ToString
public  class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        for (int elements : Example.reverse2(nums)){
            System.out.println(elements);
        }
    }
}
