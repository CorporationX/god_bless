package school.faang;

public class Example {
    //Method dlya razvorota massiva
    public static int[] reverseArray(int[] nums) {
        int[] reversed = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            reversed[i] = nums[nums.length - 1 - i];
        }
        return reversed;
    }

    public static void main(String[] args) {

        int[] original = {10, 20, 30, 40, 50, 55, 60, 65, 70}; //nachal'nqy massiv
        int[] reversed = reverseArray(original); //razvernutqy massiv

        for (int num : reversed) {
            System.out.print(num + " "); //pechataem rezul'tat :)
        }
    }
}