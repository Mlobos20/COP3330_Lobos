import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {
    // These are the 4 test cases for the 4 categories
    @Test
    public void testUnderweightCase(){
        BodyMassIndex b = new BodyMassIndex(60, 85);

        assertEquals(16.6, b.BMI);
    }

    @Test
    public void testNormalweightCase(){
        BodyMassIndex b = new BodyMassIndex(60, 115);

        assertEquals(22.5, b.BMI);
    }

    @Test
    public void testOverweightCase(){
        BodyMassIndex b = new BodyMassIndex(60, 150);

        assertEquals(29.3, b.BMI);
    }

    @Test
    public void testObeseCase(){
        BodyMassIndex b = new BodyMassIndex(60, 250);

        assertEquals(48.8, b.BMI);
    }

    //These are the test cases for each of the methods in the BodyMassIndex class
    @Test
    public void testBodyMassIndexMethod(){
        BodyMassIndex b = new BodyMassIndex(60, 115);

        assertEquals(22.5, b.BMI);
        assertEquals("Normal Weight", b.category);
    }

    @Test
    public void testCalculateMethod(){
        BodyMassIndex b = new BodyMassIndex(60, 115);

        assertEquals(22.456944444444446, b.unroundedBMI);

    }

    @Test
    public void testCategorizeMethod(){
        BodyMassIndex b = new BodyMassIndex(60, 115);

        assertEquals("Normal Weight", b.category);
    }

    @Test
    public void testRoundMethod(){
        BodyMassIndex b = new BodyMassIndex(60, 115);

        assertEquals(22.5, b.BMI);
    }
}