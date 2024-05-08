package item8.autocloseable;

import java.io.IOException;
import org.example.item8.autocloseable.AutocloseableIsGood;
import org.example.item8.autocloseable.CloseableIsGood;
import org.junit.jupiter.api.Test;

class AutoCloseableTest {

    @Test
    void autoCloseableTest() {

        try {
            AutocloseableIsGood autocloseableIsGood = new AutocloseableIsGood();
            autocloseableIsGood.close();
        } catch (Exception e) {
            System.out.println("Exception occurred.");
        }
    }

    @Test
    void closeableTest() {
        try {
            CloseableIsGood closeableIsGood = new CloseableIsGood();
            closeableIsGood.close();
        } catch (IOException e) {
            System.out.println("IOException occurred.");
        }
    }

}
