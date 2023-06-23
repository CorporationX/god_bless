package faang.school.godbless.matrix_flip;

public enum FlipDirection {
    HORIZONTAL("horizontal flip"), VERTICAL("horizontal flip");

    private String flip;

    private FlipDirection(String flip){
        this.flip = flip;
    }

    public String getFlip(){
        return flip;
    }
}
