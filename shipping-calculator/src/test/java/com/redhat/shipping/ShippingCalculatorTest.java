package com.redhat.shipping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShippingCalculatorTest {

    @Test
    void onNARegionTheCostIs100() throws RegionNotFoundException {
        testShippingCalculatorWithRegionAndCost("NA", 100);
    }

    @Test
    void onLATAMRegionTheCostIs200() throws RegionNotFoundException {
        testShippingCalculatorWithRegionAndCost("LATAM", 200);
    }

    @Test
    void onEMEAMRegionTheCostIs300() throws RegionNotFoundException {
        testShippingCalculatorWithRegionAndCost("EMEA", 300);
    }

    @Test
    void onAPACRegionTheCostIs400() throws RegionNotFoundException {
        testShippingCalculatorWithRegionAndCost("APAC", 400);
    }

    @Test
    void onNonSupportedRegionARegionNotFoundExceptionIsRaised() {
        ShippingCalculator calculator = new ShippingCalculator();
        assertThrows(
                RegionNotFoundException.class,
                () -> calculator.costForRegion("Unknown Region"));
    }

    private void testShippingCalculatorWithRegionAndCost(String region, int expectedCost) throws RegionNotFoundException {
        // Given a shipping calculator
        var shippingCalculator = new ShippingCalculator();

        // When computing the cost for the given region
        var actualCost = shippingCalculator.costForRegion(region);

        // Then the cost should be the expected
        assertEquals(expectedCost, actualCost);
    }
}
