package derschrank.sprint02.task03.bjstwo_46685;


public record Image(String name, String description) {


    @Override
    public String toString() {
        return "Image name: " + name + ", description: " + description;
    }
}
