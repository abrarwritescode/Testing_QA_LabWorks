import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import code.*;


public class DateTimeTest {

    private DateTime dateTime;

    @Before
    public void setUp() {
        dateTime = new DateTime(21, 2, 2024);
    }

    @Test
    public void testGetNameOfDay() {
        String expected = "Wednesday";
        String actual = dateTime.getNameOfDay(); //TC-009
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFormattedDate() {
        String expected = "21/02/2024";
        String actual = dateTime.getFormattedDate();
        assertEquals(expected, actual);
    }
    @Test
    public void testGetEightDigitDate() {
        String expected = "21022024";
        String actual = dateTime.getEightDigitDate();
        assertEquals(expected, actual); //TC-011
    }

    @Test
    public void testDiffDays_PositiveDifference() {
        DateTime startDate = new DateTime(19, 2, 2024);
        int difference = DateTime.diffDays(dateTime, startDate);
        assertEquals(2, difference);
    }

    @Test
    public void testSetAdvance() {
        dateTime.setAdvance(2, 2, 2);
        long expected=180000000;
        assertEquals(expected, dateTime.advance);
    }

}