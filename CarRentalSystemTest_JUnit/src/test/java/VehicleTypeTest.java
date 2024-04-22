import code.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VehicleTypeTest {
    private VehicleType carType;
    private VehicleType vanType;

    @Before
    public void setUp() {
        carType = new VehicleType(5);
        DateTime Maintenance=new DateTime(21, 02, 2024);
        vanType = new VehicleType(10,Maintenance );
    }

    @Test
    public void testGetSeats() {
        assertEquals(5, carType.getSeats("car"));
        assertEquals(10, vanType.getSeats("van"));
    }



    @Test
    public void testSetCarSeats() {
        carType.setCarSeats(4);
        assertEquals(4, carType.getCarSeats());
    }

    @Test
    public void testGetLastMaintenance() {
        DateTime Maintenance=new DateTime(21, 02, 2024);
        assertEquals(Maintenance.getEightDigitDate(), (vanType.getLastMaintenance()).getEightDigitDate());
    }



    @Test
    public void testCanBeRentedForMinimumDays() {
        DateTime monday = new DateTime(19, 02, 2024); // Monday
        DateTime friday = new DateTime(16, 02, 2024); // Friday
        DateTime sunday = new DateTime(18, 2, 2024); // Sunday
        assertEquals(2, carType.canBeRentedForMinimumDays(monday, "car"));
        assertEquals(3, carType.canBeRentedForMinimumDays(friday, "car"));
        assertEquals(1, carType.canBeRentedForMinimumDays(sunday, "van"));
    }


}
