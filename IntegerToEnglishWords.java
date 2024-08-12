// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    String[] ones = { " ", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ",
            "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ",
            "Nineteen " };

    String[] tens = { " ", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ",
            "Ninety " };

    String[] thousands = { " ", "Thousand ", "Million ", "Billion " };

    public String numberToWords(int num) {
        String result = "";

        if (num == 0)
            result = "Zero";

        int i = 0;
        while (num > 0) {
            int triplet = num % 1000;
            if (triplet != 0) {
                result = helper(triplet) + thousands[i] + result;
            }
            num /= 1000;
            i++;
        }

        return result.trim();

    }

    private String helper(int num) {
        if (num > 0 && num <= 19)
            return ones[num];

        if (num >= 20 && num <= 99)
            return tens[num / 10] + helper(num % 10);

        if (num >= 100 && num <= 999)
            return ones[num / 100] + "Hundred " + helper(num % 100);

        return "";

    }
}