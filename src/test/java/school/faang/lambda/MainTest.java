package school.faang.lambda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main = new Main();

    @Test
    void openDoor() {
        assertEquals("The door is opened by a spell: Open a door",main.openDoor(), "ErMainTest 001 - openDoor");
    }

    @Test
    void closeDoor() {
        assertEquals("The door is closed by a spell: Close a door", main.closeDoor(), "ErMainTest 002 - openWindow");
    }

    @Test
    void openWindow() {
        assertEquals("The window is opened by a spell: Open a window", main.openWindow(), "ErMainTest 003 - openWindow");
    }

    @Test
    void closeWindow() {
        assertEquals("The window is closed by a spell: Close a window", main.closeWindow(), "ErMainTest 004 - closeWindow");
    }
}