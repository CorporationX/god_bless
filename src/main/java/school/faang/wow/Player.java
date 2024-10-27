package school.faang.wow;

public record Player(String name, int level, int experience) {

    public Player updateExperience(int addExperience) {
        return new Player(this.name, this.level, this.experience + addExperience);
    }
}