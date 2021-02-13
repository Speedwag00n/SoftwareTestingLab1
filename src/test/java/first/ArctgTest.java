package first;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;


@TestInstance(value=PER_CLASS)
public class ArctgTest {

    private static final double DELTA = 0.05;

    private Arctg arctg;

    @BeforeAll
    public void init() {
        arctg = new Arctg();
    }

    @Test
    public void zeroTest() {
        double expected = 0.0;
        double actual = arctg.getResult(0.0);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void tableValuesTest1() {
        double expected = -Math.PI / 6;
        double actual = arctg.getResult(-Math.sqrt(3) / 3);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void tableValuesTest2() {
        double expected = Math.PI / 6;
        double actual = arctg.getResult(Math.sqrt(3) / 3);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void leftBoundTest() {
        double expected = -Math.PI / 4;
        double actual = arctg.getResult(-1.0);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void rightBoundTest() {
        double expected = Math.PI / 4;
        double actual = arctg.getResult(1.0);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void nanTest() {
        double expected = Double.NaN;
        double actual = Double.NaN;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        double expected = Double.NaN;;
        double actual = arctg.getResult(Double.POSITIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        double expected = Double.NaN;
        double actual = arctg.getResult(Double.NEGATIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

}