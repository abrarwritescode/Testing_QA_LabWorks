import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import code.*;
public class RentSystemTest {

    private RentSystem rentSystem;

    @Before
    public void setUp() {
        rentSystem = new RentSystem();
    }



    @Test
    public void testRent() {
        // Prepare input data for testing
        String input = "C_001\nCustomer_001\n21/02/2024\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        rentSystem.cars[0] = new Car("C_001", 2023, "Toyota", "Corolla", 0, new VehicleType(5));
        rentSystem.rent(new Scanner(System.in));
        assertEquals(1, rentSystem.cars[0].vehicleStatus);
    }



    @Test
    public void testVehicleMaintenance() {
        // Prepare input data for testing
        String input = "C_005\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Test the vehicleMaintenance method
        rentSystem.cars[0] = new Car("C_005", 2024, "Toyota", "Corolla",1, new VehicleType(4));
        rentSystem.vehicleMaintenance(new Scanner(System.in));
        assertEquals(1, rentSystem.cars[0].vehicleStatus);
    }

    @Test
    public void testCompleteMaintenance() {
        // Prepare input data for testing
        String input = "C_005\n21/02/2024\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Test the completeMaintenance method
        rentSystem.cars[0] = new Car("C_005", 2022, "Toyota", "Corolla", 2, new VehicleType(4));
        rentSystem.completeMaintenance(new Scanner(System.in));
        assertEquals(2, rentSystem.cars[0].vehicleStatus);
    }


}