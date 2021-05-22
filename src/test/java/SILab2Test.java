import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void function() {
    }

    private List<Time> createList(Time elems) {
        return new ArrayList<Time>(Arrays.asList(elems));
    }

    private List<Integer> returnList(Integer elems) {
        return new ArrayList<Integer>(Arrays.asList(elems));
    }

    @Test
    void everyBranch() {
        RuntimeException ex;

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(-2, 30, 50))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(25, 30, 50))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        //The minutes are not valid!
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(23, -2, 50))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));
        //The seconds are not valid
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(23, 2, 61))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(24, 61, 61))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

	List<Time> empty = new ArrayList<Time>(0);
        assertEquals(empty, SILab2.function(empty));

        assertEquals(returnList(73550), SILab2.function(createList(new Time(20, 25, 50))));
        assertEquals(returnList(86400), SILab2.function(createList(new Time(24, 0, 0))));
        
    }

    @Test
    void multipleCondition() {
        RuntimeException ex;

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(-14, 27, 40))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(28, 32, 52))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        assertEquals(returnList(73550), SILab2.function(createList(new Time(20, 25, 50))));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(10, -22, 53))));
        assertTrue(ex.getMessage().contains("The minutes are not valid"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(12, 64, 32))));
        assertTrue(ex.getMessage().contains("The minutes are not valid"));

        assertEquals(returnList(73550), SILab2.function(createList(new Time(20, 25, 50))));


        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(12, 45, 69))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(21, 42, -27))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));


        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(24, 0, 10))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(24, 14, 15))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        assertEquals(returnList(73550), SILab2.function(createList(new Time(20, 25, 50))));
    }
}