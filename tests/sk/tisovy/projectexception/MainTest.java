package sk.tisovy.projectexception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void add() {
        Main main=new Main();
        assertEquals(main.add(5,8),14);
    }
}