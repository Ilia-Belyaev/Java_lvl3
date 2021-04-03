package Array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateArrayTest {
    private CreateArray createArray;
    @BeforeEach
    void setUp() {
        createArray = new CreateArray();
    }
    @Test
    void condition() {
        Assertions.assertArrayEquals(new int[]{5,6,7,8,9,10},CreateArray.condition(new int[]{1,2,3,4,5,6,7,8,9,10}));
        System.out.println();
    }
    @Test
    void condition2(){
        Assertions.assertArrayEquals(new int[]{10},CreateArray.condition(new int[]{1,2,3,4,4,6,7,8,4,10}));
        System.out.println();
    }
    @Test
    void condition3(){
        Assertions.assertArrayEquals(new int[]{},CreateArray.condition(new int[]{1,2,3,4,5,6,7,8,9,4}));
        System.out.println();
    }
    @Test
    void condition4(){
        Assertions.assertArrayEquals(new int[]{2,3,5,6,7,8,9,10,10},CreateArray.condition(new int[]{4,2,3,5,6,7,8,9,10,10}));
        System.out.println();
    }
}


//class CreateArrayTest {
//    private CreateArray createArray;
//    @BeforeEach
//    void setUp() {
//        createArray = new CreateArray(10);
//    }
//
//
//    @Test
//    void condition(){
//        Assertions.assertArrayEquals(new int[]{5,6,7,8,9,10},CreateArray.condition(new int[]{1,2,3,4,5,6,7,8,9,10}));
//        System.out.println();
//    }
//
////    @Test
////    void condition2(){
////        Assertions.assertArrayEquals(new int[]{10},CreateArray.condition(new int[]{1,2,3,4,4,6,7,8,4,10}));
////        System.out.println();
////    }
////    @Test
////    void condition3(){
////        Assertions.assertArrayEquals(new int[]{},CreateArray.condition(new int[]{1,2,3,4,5,6,7,8,9,4}));
////        System.out.println();
////    }
////    @Test
////    void condition4(){
////        Assertions.assertArrayEquals(new int[]{2,3,5,6,7,8,9,10,10},CreateArray.condition(new int[]{4,2,3,5,6,7,8,9,10,10}));
////        System.out.println();
////    }
//}
