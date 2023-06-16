package faang.school.godbless.turn_around;

public class Example {
    int[] num;

    Example (int[] num){
        this.num = num;
    }
    public int[] getNum() {
        return num;
    }
    public void reverse(int[] num) {
        for(int i = 0; i < num.length/2; i++) {
            int temp = num[i];
            num[i] = num[num.length-1-i];
            num[num.length-1-i] = temp;
        }
    }
}
