package school.faang.lambda;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        System.out.println(main.openDoor());
        System.out.println(main.closeDoor());
        System.out.println(main.openWindow());
        System.out.println(main.closeWindow());
    }

    public String openDoor(){
        return new SpellCaster().cast("Open a door",phraseSA -> "The door is opened by a spell: " + phraseSA);
    }
    public String openWindow(){
        return new SpellCaster().cast("Open a window",phraseSA -> "The window is opened by a spell: " + phraseSA);
    }
    public String closeDoor(){
        return new SpellCaster().cast("Close a door",phraseSA -> "The door is closed by a spell: " + phraseSA);
    }
    public String closeWindow(){
        return new SpellCaster().cast("Close a window",phraseSA -> "The window is closed by a spell: " + phraseSA);
    }
}