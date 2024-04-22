import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import code.*;

public class CarTest {

    private Car car;

    private DateTime rentDate;

    @Before
    public void setUp() {
        car = new Car("C_-Gha", 2020, "Toyota", "Corolla", 0, new VehicleType(5));
        rentDate = new DateTime(4,12,2001);
    }

    @Test
    public void testGetLateFee_PositiveDifference() {
        DateTime startDate = new DateTime(2,12,2023);
        DateTime endDate = new DateTime(5,12,2023);
        double lateFee = car.getLateFee(endDate, startDate);
        assertEquals(1.25 * 78 * 3, lateFee, 0.01); // 1.25 * rentRate * days
    }

    @Test
    public void testGetLateFee_NegativeDifference() {
        DateTime startDate = new DateTime(2, 12, 2023);
        DateTime endDate = new DateTime(1, 12, 2023);
        double lateFee = car.getLateFee(endDate, startDate);
        assertEquals(0.0, lateFee, 0.01); // Late fee should be 0 for negative difference
    }

    @Test
    public void testGetLateFee_ZeroDifference() {
        DateTime startDate = new DateTime(2, 12, 2023);
        DateTime endDate = new DateTime(2, 12, 2023);
        double lateFee = car.getLateFee(endDate, startDate);
        assertEquals(0.0, lateFee, 0.01); // Late fee should be 0 for 0 difference
    }

    @Test
    public void testReturnVehicle_SuccessfulReturn() {
        car.rent("Cust_001", new DateTime(3, 4, 2024), 5);
        boolean isReturned = car.returnVehicle(new DateTime(8, 4, 2024)); // Return after 5 days
        assertTrue(isReturned);
    }
    @Test
    public void testReturnVehicle_UnsuccessfulReturn() {
        boolean isReturned = car.returnVehicle(new DateTime(2, 3, 2014));
        assertFalse(isReturned);
    }

    @Test
    public void testCompleteMaintenance_SuccessfulCompletion() {
        car = new Car("C_-Gha", 2020, "Toyota", "Corolla", 2, new VehicleType(5));
        boolean isCompleted = car.completeMaintenance();
        assertTrue(isCompleted);

    }

    @Test
    public void testCompleteMaintenance_UnsuccessfulCompletion() {
        boolean isCompleted = car.completeMaintenance(); // complete maintenance without being in maintenance-tc-007
        assertFalse(isCompleted);
    }

    @Test
    public void testGetDetails_NoRentalRecord() {
        String expected = "Vehicle ID:\tC_-Gha\n Year:\t 2020\n Make:\tToyota\n Model:\tCorolla\n Number of Seats:\t5\n Status:\tAvailable\nRENTAL RECORD:\tempty";
        String actual = car.getDetails();
        assertEquals(expected, actual);
    }



}
