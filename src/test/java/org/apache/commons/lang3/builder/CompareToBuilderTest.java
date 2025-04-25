package org.apache.commons.lang3.builder;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.commons.lang3.AbstractLangTest;
import org.junit.jupiter.api.Test;

/**
 * Tests {@link CompareToBuilder}.
 */

 public class CompareToBuilderTest extends AbstractLangTest {
    //Testing object comparisons using Bottom-Up Integration testing

    //Tests for the append method that compares ints
    @Test
    public void appendIntTest(){
        //Basic Comparison
        assertTrue(new CompareToBuilder().append(0, 1000).toComparison() < 0);
        assertTrue(new CompareToBuilder().append(1000, 0).toComparison() > 0);

        //Equality
        assertTrue(new CompareToBuilder().append(50, 50).toComparison() == 0);
    }
 }