import code.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VehicleTest {
    private VehicleType carType;
    private VehicleType vanType;
    private Vehicle car;
    private Vehicle van;

    @Before
    public void setUp() {
        carType = new VehicleType(5);
        vanType = new VehicleType(10);
        car = new Vehicle("C_001", 2024, "Toyota", "Corolla", 0, carType);
        van = new Vehicle("V_001", 2024, "Toyota", "Rush", 0, vanType);
    }

    @Test
    public void testGetVehicleId() {
        assertEquals("C_001", car.getVehicleId());
        assertEquals("V_001", van.getVehicleId());
    }

    @Test
    public void testRentCar() {
        DateTime rentDate = new DateTime(2, 2, 2024);
        assertTrue(car.rent("customer1", rentDate, 3));//TC-029
        assertEquals(1, car.vehicleStatus); //TC-020
    }





    @Test
    public void testToString() {
        String carExpected = "C_001:2024:Toyota:Corolla:5:Available";
        String vanExpected = "V_001:2024:Toyota:Rush:15:Available";
        assertEquals(carExpected, car.toString());
        assertEquals(vanExpected, van.toString());
    }

    @Test
    public void testGetDetails() {
        String carDetailsExpected = "Vehicle ID:\tC_001\n Year:\t 2024\n Make:\tToyota\n Model:\tCorolla\n Number of Seats:\t5\n Status:\tAvailable";
        String vanDetailsExpected = "Vehicle ID:\tV_001\n Year:\t 2024\n Make:\tToyota\n Model:\tRush\n Number of Seats:\t15\n Status:\tAvailable";
        assertEquals(carDetailsExpected, car.getDetails());
        assertEquals(vanDetailsExpected, van.getDetails());
    }

    @Test
    public void testGetLastElementIndex() {
        assertEquals(-1, car.getLastElementIndex());
        car.records[0] = new RentalRecord("R_001", new DateTime(), new DateTime());
        assertEquals(0, car.getLastElementIndex());
    }
}
