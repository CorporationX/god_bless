package school.faang.bjs245299;

public enum SubjectData {
    MATH,
    LANG,
    INFO,
    JAVA;

    public Subject createSubject() {
        return new Subject(this.name());
    }
}
