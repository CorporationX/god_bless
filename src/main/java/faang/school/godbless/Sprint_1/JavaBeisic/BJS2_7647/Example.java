package faang.school.godbless.Sprint_1.JavaBeisic.BJS2_7647;

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
