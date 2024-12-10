import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
        @Test
        void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }
        @Test
        void int2NumberTest() {
           int[] toConvert ={10,20,39,45};
           int base =2;
           String[] result = {"1010b2", "10100b2", "100111b2", "101101b2"};
            for (int i = 0; i < toConvert.length; i++) {
                 {
                    String actualResult = Ex1.int2Number(toConvert[i], base);
                    assertEquals(result[i], actualResult);
                }
            }
           }
        @Test
        void maxIndexTest() {
            ByteArrayOutputStream content = new ByteArrayOutputStream();
            System.setOut(new PrintStream(content));
            Ex1.maxIndex(10,42,52,420, "52b8", "420b8");// we take 8 as base.
            assertTrue(content.toString().contains("max number over [10,42,52b8,420b8] is: 420b8"));
        }

    @Test
    void whichNumber() {
            String[] good ={"2","5","9","A","D","G"};
            int[] expect = {2,5,9,10,13,16};
            int[] compare =new int[6];
            for(int i=0;i<good.length;i++) {
                char represent = good[i].charAt(0);
                compare[i] = Ex1.whichNumber(represent);
                assertEquals(compare[i],expect[i]);
                }
            }
    }


    // Add additional test functions - test as much as you can.

