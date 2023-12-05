package faang.school.godbless.multithreading.parallelism_thread.normal_game;

public enum MaterialEnum {
    BRICK(new Material(1, "brick")),
    STRAW(new Material(2, "straw")),
    STICK(new Material(3, "stick"));

    private Material material;

    MaterialEnum(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }
}
