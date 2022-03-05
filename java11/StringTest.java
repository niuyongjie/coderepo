

import org.junit.Test;

import static org.testng.Assert.assertEquals;

class StringTest {

    @Test
    void StringTest(){
        String nameStr = "    Java Niu    ";
        assertEquals("Java Niu", nameStr.strip());
    }

}