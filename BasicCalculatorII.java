// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        s = s.trim();
        int n = s.length();

        int num = 0;
        char lastSign = '+';
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                num = num * 10 + c - '0';

            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                if (lastSign == '+') {
                    st.push(num);
                } else if (lastSign == '-') {
                    st.push(-num);
                } else if (lastSign == '*') {
                    st.push(st.pop() * num);
                } else
                    st.push(st.pop() / num);

                num = 0;
                lastSign = c;
            }
        }

        int calc = 0;
        while (!st.isEmpty()) {
            calc += st.pop();
        }

        return calc;

    }
}