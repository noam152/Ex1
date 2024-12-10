import java.util.Objects;

/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = -1;
        if(isNumber(num)) {
            if (num.matches(".*[0-9].*") && !num.matches(".*[A-Zb].*")) { // return the number in case of decimal
                int decimal = Integer.parseInt(num);
                return decimal;
            }
            String[] arr = num.split("b");
            String numPart = arr[0];
            String basePart = arr[1];
            char baseChar = basePart.charAt(0);
            int base = whichNumber(baseChar);
            char[] charArray = numPart.toCharArray();
            int sum = 0;
            for (int i = 0; i < charArray.length; i++) {
                int numBase = whichNumber(charArray[charArray.length - 1 - i]);
                sum += (int) (numBase * (Math.pow(base, i)));
            }
            return sum;
            ////////////////////
        }
        else
            return ans;
    }

    /**
     * This static function checks the numerical representation of the number.
     * @param base check the value of the char
     * @return the base of the numbers (this helps us to convert A,B,C,D,E,F,G to numbers).
     */
    public static int whichNumber(char base) {
        char[] baseChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int numberBase = 0;
        for (int i = 0; i < baseChar.length; i++) {
            if (baseChar[i] == base) {
                numberBase = i;
                return i;
            }
        }
        return -1;
    }

    /**
     * This static function is a functions that checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        if (a == null || a.isEmpty()) // check if the number contain something
            return false;
        if (!a.matches("^[A-Gb0-9]+$"))// check that the number contain only valid chars.
            return false;
        if (a.matches(".*[0-9].*") && !a.matches(".*[A-Zb].*"))// check if the number is decimal.
            return true;
        if (a.matches(".*[A-Z].*") && !a.matches(".*[0-9b].*"))// if the number isn't contain numbers, he isn't valid.
            return false;
        if (a.charAt(a.length() - 2) != 'b')// the char in the place -1 before the end have to be "b"
            return false;
        String[] arr = a.split("b");
        String numPart = arr[0];
        String basePart = arr[1];
        if (arr.length != 2)
            return false;
        if (numPart.isEmpty() || basePart.isEmpty()) // check if one of the parts is empty
            return false;
        if (!basePart.matches(".*[A-G].*")) {// check that the representation of the base is in the valid format in case that the base represent in by number
            int base = Integer.parseInt(basePart);//
            if (base > 9)
                return false;
        }
        char baseChar = basePart.charAt(0);
        int base = whichNumber(baseChar);
        char[] charArray = numPart.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int numBase = whichNumber(charArray[charArray.length - 1 - i]);
            if (base > 16 || base < 2 || numBase < 0)
                return false;
            if (numBase >= base)
                return false;
        }
        return true;
    }

        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number(int num, int base) {
            String ans = "";
            if(base > 16 || base < 2)
                return ans;
            int temp1;
            StringBuilder finalNumber = new StringBuilder();
            while (num > 0) {
                temp1 = num%base;
                num = num/base;
                finalNumber.append(temp1);
            }
            String temporaryResult = finalNumber.toString();
            String reversed = new StringBuilder(temporaryResult).reverse().toString();
            ans = reversed +"b"+base;
            return ans;
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {
            int a = number2Int(n1);
            int b = number2Int(n2);
            boolean ans = true;
            if(a==b) {
                return true;
            }
            return false;
        }

        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param add,multiply numbers
         * @return the index in the array in with the largest number (in value).
         *
         */

        public static void maxIndex(int a, int b,int add, int multiply,String add1,String multiply1) {
            int ans = 0;
                if(add >= multiply)
                    System.out.println("max number over [" +a + "," + b + "," + add1 + "," + multiply1 +  "] is: " + add1 );
                else
                    System.out.println("max number over [" +a + "," + b + "," + add1 + "," + multiply1 +  "] is: " + multiply1 );
        }
}
