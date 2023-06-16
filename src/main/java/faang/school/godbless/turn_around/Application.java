package faang.school.godbless.turn_around;

public class Application {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5};
        Example example = new Example(num);
        example.reverse(num);
        for(int i = 0; i < example.getNum().length; i++) {
            System.out.print(example.getNum()[i]);
        }
    }
}
