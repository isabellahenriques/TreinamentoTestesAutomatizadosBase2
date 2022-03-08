import org.junit.Assert;
import org.junit.Test;

public class JUnitDesafio {
    //1. assertTrue
    @Test
    public void primeiroTesteComAssertTrue(){
        String fruta = "Banana";
        Assert.assertTrue(fruta.equals("Banana"));
    }

    // 2. asserFalse
    @Test
    public void primeiroTesteComAssertFalse(){
        String fruta = "Banana";
        Assert.assertFalse(fruta.equals("Maçã"));
    }

    // 3. assertEquals
    @Test
    public void primeiroTesteComAssertEquals(){
        Assert.assertEquals(4, 2+2);
    }
}
