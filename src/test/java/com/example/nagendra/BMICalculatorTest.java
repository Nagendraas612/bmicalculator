package com.example.nagendra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BMICalculatorTest {

    // Test 1: BMI calculation
	@Test
	void testBMICalculation() {
	    double bmi = BMICalculator.calculateBMI(68, 1.7);
	    assertEquals(25.00, bmi, 0.01); // Intentional wrong expected value
	}

    // Test 2: Underweight
    @Test
    void testUnderweight() {

        assertEquals("Underweight",
            BMICalculator.getCategory(18.49));
    }

    // Test 3: Normal
    @Test
    void testNormal() {

        assertEquals("Normal",
            BMICalculator.getCategory(22));
    }

    // Test 4: Overweight
    @Test
    void testOverweight() {

        assertEquals("Overweight",
            BMICalculator.getCategory(27));
    }

    // Test 5: Obese
    @Test
    void testObese() {

        assertEquals("Obese",
            BMICalculator.getCategory(32));
    }

    // Test 6: Category boundaries
    @Test
    void testCategoryBoundaries() {

        assertEquals("Underweight",
            BMICalculator.getCategory(18.49));

        assertEquals("Normal",
            BMICalculator.getCategory(18.5));

        assertEquals("Normal",
            BMICalculator.getCategory(24.99));

        assertEquals("Overweight",
            BMICalculator.getCategory(25));

        assertEquals("Overweight",
            BMICalculator.getCategory(29.99));

        assertEquals("Obese",
            BMICalculator.getCategory(30));
    }

    // Test 7: Invalid weight
    @Test
    void testInvalidWeight() {

        assertThrows(IllegalArgumentException.class,
            () -> BMICalculator.calculateBMI(0, 1.7));

        assertThrows(IllegalArgumentException.class,
            () -> BMICalculator.calculateBMI(-10, 1.7));
    }

    // Test 8: Invalid height
    @Test
    void testInvalidHeight() {

        assertThrows(IllegalArgumentException.class,
            () -> BMICalculator.calculateBMI(68, 0));

        assertThrows(IllegalArgumentException.class,
            () -> BMICalculator.calculateBMI(68, -1.7));
    }

    // Test 9: Extreme values
    @Test
    void testExtremeValues() {

        assertThrows(IllegalArgumentException.class,
            () -> BMICalculator.calculateBMI(501, 1.7));

        assertThrows(IllegalArgumentException.class,
            () -> BMICalculator.calculateBMI(68, 2.9));

        assertThrows(IllegalArgumentException.class,
            () -> BMICalculator.calculateBMI(68, 0.4));
    }

    // Test 10: Non-finite values
    @Test
    void testNonFiniteValues() {

        assertThrows(IllegalArgumentException.class,
            () -> BMICalculator.calculateBMI(Double.NaN, 1.7));

        assertThrows(IllegalArgumentException.class,
            () -> BMICalculator.calculateBMI(68,
                Double.POSITIVE_INFINITY));
    }

    // Test 11: Invalid BMI
    @Test
    void testInvalidBMI() {

        assertThrows(IllegalArgumentException.class,
            () -> BMICalculator.getCategory(0));

        assertThrows(IllegalArgumentException.class,
            () -> BMICalculator.getCategory(-5));
    }
}
