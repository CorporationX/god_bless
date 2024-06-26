package faang.school.godbless.Sprint_1.JavaBeisic.BJS2_7647;

//Создать класс Example. В нём объявить метод, который принимает массив целых чисел в качестве параметр
//rse. Этот метод должен разворачивать переданный массив.
//Пример: nums = [1,2,3,4,5] → reverse(nums) → nums = [5,4,3,2,1].

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        int[] number = {1,2,3,4,5};
        System.out.println("---------------------------------");
        System.out.print("Massive : ");
        for(int array : number){
            System.out.print(array + " ");
        }
        int[] expandedArray = example.reverse(number);
        System.out.print("\n" + "Expanded Array : ");
        for(int array : expandedArray){
            System.out.print(array + " ");
        }
        System.out.println("\n" + "---------------------------------");

    }
}
