package CompositionArray;

import Array.CreateArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStructureTest {
    private ArrayStructure arrayStructure;
    @BeforeEach
    void setUp() {
        arrayStructure = new ArrayStructure();
    }
    @Test
    void createArray() {
        Assertions.assertEquals( false,ArrayStructure.createArray(new int[]{1,1,1,1,1,1,1,1}));
    }
    @Test
    void createArray1() {
        Assertions.assertEquals( true,ArrayStructure.createArray(new int[]{4,1,1,1,1,1,1,1}));
    }
    @Test
    void createArray2() {
        Assertions.assertEquals( true,ArrayStructure.createArray(new int[]{1,1,4,4,1,1,4,1}));
    }
    @Test
    void createArray3() {
        Assertions.assertEquals( false,ArrayStructure.createArray(new int[]{4,4,4,4,4,4,4,4}));
    }
}