/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.sort.linearithmic;

import edu.neu.coe.info6205.sort.GenericSort;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.SortWithHelper;
import edu.neu.coe.info6205.util.Config;
import edu.neu.coe.info6205.util.ConfigTest;
import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 60444
 */
public class TimSortTest {
    
    @Test
    public void TimSortTest0() {
        Integer[] xs = new Integer[4];
        xs[0] = 3;
        xs[1] = 4;
        xs[2] = 2;
        xs[3] = 1;
        GenericSort<Integer> s = new TimSort<>(xs.length, config);
        Integer[] ys = s.sort(xs);
        assertEquals(Integer.valueOf(1), ys[0]);
        assertEquals(Integer.valueOf(2), ys[1]);
        assertEquals(Integer.valueOf(3), ys[2]);
        assertEquals(Integer.valueOf(4), ys[3]);
    }
    
    @Test
    public void TimSortTest1() {
        String testString = "SEAYRLFVZQTCMK";
        char[] charArray = testString.toCharArray();
        Character[] array = new Character[charArray.length];
        GenericSort<Character> s = new TimSort<>(array.length, config);
        for (int i = 0; i < array.length; i++) array[i] = charArray[i];
        final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        s.sort(array,0,array.length);
        char[] chars = new char[array.length];
        for (int i = 0; i < chars.length; i++) chars[i] = array[i];
        String partitionedString = new String(chars);
        assertEquals("ACEFKLMQRSTVYZ", partitionedString);
    }
    
    @Test
    public void TimSortTest2() {
        Integer[] xs = new Integer[4];
        xs[0] = 3;
        xs[1] = 4;
        xs[2] = 2;
        xs[3] = 1;
        GenericSort<Integer> s = new TimSort<>(xs.length, config);
        s.sort(xs,1,4);
        assertEquals(Integer.valueOf(3), xs[0]);
        assertEquals(Integer.valueOf(1), xs[1]);
        assertEquals(Integer.valueOf(2), xs[2]);
        assertEquals(Integer.valueOf(4), xs[3]);
    }
    
    @Test
    public void testSortWithInstrumenting() throws Exception {
        int n = 16;
        final SortWithHelper<Integer> sorter = new TimSort<>(n, config);
        final Helper<Integer> helper = sorter.getHelper();
        final Integer[] xs = helper.random(Integer.class, r -> r.nextInt(10));
        final Integer[] sorted = sorter.sort(xs);
        assertTrue(helper.sorted(sorted));
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        config = Config.load();
    }
    private static Config config;

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
