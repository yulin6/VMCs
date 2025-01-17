import objects.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import util.JsonMachineConverterTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CoinTest.class,
        DoorTest.class,
        DrinkTest.class,
        SlotTest.class,
        MachineTest.class,
        JsonMachineConverterTest.class,
})
public class TestSuite {
}
