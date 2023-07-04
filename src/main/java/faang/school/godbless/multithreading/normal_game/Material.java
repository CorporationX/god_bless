package faang.school.godbless.multithreading.normal_game;

public enum Material {
    STRAW(200),
    STICKS(300),
    BRICKS(700);

    final int constructionTime;

    Material(int constructionTime) {
        this.constructionTime = constructionTime;
    }
}
