import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import code.*;

public class RentalRecordTest {

    private RentalRecord rentalRecord;
    private DateTime rentDate;
    private DateTime estimatedReturnDate;
    private DateTime actualReturnDate;

    @Before
    public void setUp() {
        // Initialize RentalRecord object and DateTime objects before each test
        rentDate = new DateTime(21, 2, 2024);
        estimatedReturnDate = new DateTime(23, 2, 2024);
        rentalRecord = new RentalRecord("R_001", rentDate, estimatedReturnDate);
    }

    @Test
    public void testGetEstimatedReturnDate() {
        DateTime expected = estimatedReturnDate;
        DateTime actual = rentalRecord.getEstimatedReturnDate();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetRentDate() {
        DateTime expected = rentDate;
        DateTime actual = rentalRecord.getRentDate();
        assertEquals(expected, actual);
    }

    @Test
    public void testToString_NoActualReturn() {
        String expected = "R_001:21/02/2024:23/02/2024:none:none:none";
        String actual = rentalRecord.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToString_WithActualReturn() {
        actualReturnDate = new DateTime(25, 02, 2024);
        rentalRecord.setData(actualReturnDate, 200.0, 50.0);
        String expected = "R_001:21/02/2024:23/02/2024:25/02/2024:200.0:50.0";
        String actual = rentalRecord.toString();
        assertEquals(expected, actual);
    }




    @Test
    public void testGetDetails_NoActualReturn() {
        String expected =
                "Record ID:             R_001\n" +
                        "Rent Date:             21/02/2024\n" +
                        "Estimated Return Date: 23/02/2024";
        String actual = rentalRecord.getDetails();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetDetails_WithActualReturn() {
        actualReturnDate = new DateTime(25, 02, 2024);
        rentalRecord.setData(actualReturnDate, 200.0, 50.0);
        String expected =
                "Record ID:             R_001\n" +
                        "Rent Date:             21/02/2024\n" +
                        "Estimated Return Date: 23/02/2024\n" +
                        "Actual Return Date:    25/02/2024\n" +
                        "Rental Fee:            200.00\n" +
                        "Late Fee:              50.00";
        String actual = rentalRecord.getDetails();
        assertEquals(expected, actual);
    }
}