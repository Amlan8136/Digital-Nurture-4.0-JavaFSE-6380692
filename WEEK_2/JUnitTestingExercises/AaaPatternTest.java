import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class AaaPatternTest {

    private int a;
    private int b;

    @Before
    public void setUp() {
        a = 10;
        b = 5;
        System.out.println("Setup completed.");
    }

    @Test
    public void testAddition() {
        int expected = 15;
        int result = a + b;

        assertEquals(expected, result);
    }

    @Test
    public void testSubtraction() {
        int expected = 5;
        int result = a - b;
        assertEquals(expected, result);
    }

    @After
    public void tearDown() {
        System.out.println("Teardown done.");
    }
}
