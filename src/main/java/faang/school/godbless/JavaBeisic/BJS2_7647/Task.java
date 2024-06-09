package faang.school.godbless.JavaBeisic.BJS2_7647;

public class Task {
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

class Example{
    int[] reverse(int[] massive){
        for (int i = 0; i < massive.length / 2; i++) {
            int saveNum = massive[i];
            massive[i] = massive[massive.length - i - 1];
            massive[massive.length - i - 1] = saveNum;
        }
        return massive;
    }
}
