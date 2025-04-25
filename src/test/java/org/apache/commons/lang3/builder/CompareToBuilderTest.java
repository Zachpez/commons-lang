package org.apache.commons.lang3.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    
    //Tests for the append method that compares chars
    @Test
    public void appendCharTest(){
        //Basic comparison
        assertTrue(new CompareToBuilder().append('a', 'z').toComparison() < 0);
        assertTrue(new CompareToBuilder().append('z', 'a').toComparison() > 0);

        //Case differences
        assertTrue(new CompareToBuilder().append('a', 'A').toComparison() > 0);
        assertTrue(new CompareToBuilder().append('A', 'Z').toComparison() < 0);
        assertTrue(new CompareToBuilder().append('Z', 'A').toComparison() > 0);

        //Equality
        assertEquals(0, new CompareToBuilder().append('G', 'G').toComparison());
        assertEquals(0, new CompareToBuilder().append('%', '%').toComparison());
    }

    //Tests for the append method that compares booleans
    @Test
    public void appendBoolTest(){
        boolean a = false;
        boolean b = true;

        //Different Boolean Value
        assertTrue(new CompareToBuilder().append(a, b).toComparison() < 0);
        assertTrue(new CompareToBuilder().append(b, a).toComparison() > 0);

        //Self Equality
        assertEquals(0, new CompareToBuilder().append(a, a).toComparison());
        assertEquals(0, new CompareToBuilder().append(b, b).toComparison());
    }
    
    //Tests for the append method that compares integer arrays
    @Test
    public void appendIntArrayTest(){
        int[] a = {1};
        int[] b = {10};
        int[] c = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] d = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] e = {2, 3, 4, 5, 6, 7, 8, 8, 10};

        //Self Equality
        assertEquals(0, new CompareToBuilder().append(a, a).toComparison());
        assertEquals(0, new CompareToBuilder().append(c, c).toComparison());
        
        //Null handling
        assertTrue(new CompareToBuilder().append(null, a).toComparison() < 0);
        assertTrue(new CompareToBuilder().append(a, null).toComparison() > 0);
        
        //Single Element comparison
        assertTrue(new CompareToBuilder().append(a, b).toComparison() < 0);
        assertTrue(new CompareToBuilder().append(b, a).toComparison() > 0);

        //Array Length Difference
        assertTrue(new CompareToBuilder().append(a, c).toComparison() < 0);
        assertTrue(new CompareToBuilder().append(c, a).toComparison() > 0);
        
        //Multi Element Comparison
        assertTrue(new CompareToBuilder().append(c, d).toComparison() < 0);
        assertTrue(new CompareToBuilder().append(d, c).toComparison() > 0);
        assertTrue(new CompareToBuilder().append(c, e).toComparison() < 0);
        assertTrue(new CompareToBuilder().append(e, c).toComparison() > 0);
    }
 }