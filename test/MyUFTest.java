import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyUFTest {
    
    private MyUF uf;

    @Before
    public void setUp() {
        uf = new MyUF(10); // не работает!!!
    }

    @Test
    public void unionEndIsConnected() {
        uf.union(0, 1);
        uf.union(8, 9);

        assertTrue(uf.isConnected(8, 9));
        assertTrue(uf.isConnected(0, 1));

        uf.union(6, 9);
        uf.union(5, 6);
        uf.union(1, 5);

        assertTrue(uf.isConnected(0,9));
    }
}
