import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class IterTest {
    Iter<String > arr=new Iter<String>(10);

    @Before
    public void setUp() throws Exception {
        for(int i=0; i<10; i++){
            arr.put(i, "String"+i);
        }
    }

    @Test
    public void put() {
        arr.put(0, "qqq");
        assertEquals(arr.get(0), "qqq");
        arr.put(0, "String0");
    }

    @Test
    public void get() {
        assertEquals(arr.get(0), "String0");
    }
}
