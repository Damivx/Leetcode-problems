public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int cycleLen = 2 * numRows - 2;

        // Iterate over each row
        for (int i = 0; i < numRows; i++) {
            // Iterate over characters in the current row
            for (int j = i; j < s.length(); j += cycleLen) {
                result.append(s.charAt(j));

                // For the rows other than the first and last, add characters between them
                if (i > 0 && i < numRows - 1) {
                    int midIndex = j + cycleLen - 2 * i;
                    if (midIndex < s.length()) {
                        result.append(s.charAt(midIndex));
                    }
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        int numRows = 3;
        String converted = convert(input, numRows);
        System.out.println(converted);
    }
}
