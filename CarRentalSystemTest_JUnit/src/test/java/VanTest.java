import code.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VanTest {

    private Van van;

    @Before
    public void setUp() {

        VehicleType vehicleType = new VehicleType(15);
        DateTime lastMaintenanceDate = new DateTime(2, 3, 2024);
        vehicleType.setLastMaintenance(lastMaintenanceDate);
        van = new Van("V_001", 2024, "Toyota", "RUSH", 0, vehicleType);
    }

    @Test
    public void testGetLateFee() {

        DateTime startDate = new DateTime(21, 2, 2024);
        DateTime endDate = new DateTime(26, 2, 2024);
        assertEquals(299 * 5, van.getLateFee(endDate, startDate),0); // Expected late fee: 299 * 5 --TC-023

        startDate = new DateTime(2024, 3, 20);
        endDate = new DateTime(2024, 3, 15); // End date before start date
        assertEquals(0, van.getLateFee(endDate, startDate),0); // Expected late fee: 0
    }



    @Test
    public void testCompleteMaintenance() {

        DateTime completionDate = new DateTime(2, 3, 2024);
        assertTrue(van.completeMaintenance(completionDate)); // TC-025

        // Within 12 days again
        DateTime invalidCompletionDate = new DateTime(5, 3, 2024);
        assertFalse(van.completeMaintenance(invalidCompletionDate));
    }

    @Test
    public void testToString() {

        String expected = "V_001:2024:Toyota:RUSH:15:Available:02/03/2024";
        assertEquals(expected, van.toString());
    }

}