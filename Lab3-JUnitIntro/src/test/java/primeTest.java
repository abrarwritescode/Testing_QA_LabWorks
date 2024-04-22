import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.example.math;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class primeTest {
    @Test
    public void Test2() throws Exception {
        math math=new math();

        assertTrue(math.isPrime(2));

    }

    @Test
    public void Test1000000000000000() throws Exception {
        math math=new math();
        assertFalse(math.isPrime(1000000000000L));

    }

    @Test
    public void Test20() throws Exception {
        math math=new math();
        assertFalse(math.isPrime(20));

    }
    @Test
    public void Test47() throws Exception {
        math math=new math();
        assertTrue(math.isPrime(47));


    }
    @Test
    public void Test993() throws Exception {
        math math=new math();
        assertFalse(math.isPrime(993));
    }

    @Test(expected= Exception.class)
    public void Testminus2() throws Exception {
        math math=new math();
        assert(math.isPrime(-2));
    }

    @Test(expected= Exception.class)
    public void Test1() throws Exception {
        math math=new math();
        assert(math.isPrime(1));
    }

    @Test(expected= Exception.class)
    public void Test1000000000001() throws Exception {
        math math=new math();
        assert(math.isPrime(1000000000001L));
    }

    @Ignore
    @Test(expected= Exception.class)
    public void Test2point2() throws Exception {
        math math=new math();
        assert(math.isPrime(2.2));
    }



    @RunWith(Parameterized.class)
    public class PrimeNumberCheckerTestJUNIT4 {
        private Integer inputNumber;
        private Boolean expectedResult;
        private PrimeNumberChecker primeNumberChecker;
        @Before
        public void initialize() {
            primeNumberChecker = new PrimeNumberChecker();
        }
        public PrimeNumberCheckerTestJUNIT4(Integer inputNumber, Boolean expectedResult) {
            this.inputNumber = inputNumber;
            this.expectedResult = expectedResult;
        }

        @Parameterized.Parameters
        public static Collection primeNumbers() {
            return Arrays.asList(new Object[][] {
                    { 2, true },
                    { 6, false },
                    { 19, true },
                    { 22, false },
                    { 23, true }
            });
        }
        @Test
        public void testPrimeNumberChecker() {
            System.out.println("Parameterized Number is : " + inputNumber);
            assertEquals(expectedResult,
                    primeNumberChecker.validate(inputNumber));
        }
    }



}
