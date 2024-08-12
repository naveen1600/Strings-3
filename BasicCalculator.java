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
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }

            if (c == '(') {
                if (lastSign == '+')
                    st.push(1);
                else
                    st.push(-1);
                st.push(Integer.MIN_VALUE);
                num = 0;
                lastSign = '+';
            } else if (c == ')') {
                if (lastSign == '+')
                    st.push(num);
                else
                    st.push(-num);

                int calc = 0;
                while (st.peek() != Integer.MIN_VALUE) {
                    calc += st.pop();
                }
                st.pop();
                st.push(st.pop() * calc);
                num = 0;
                lastSign = '+';
            } else if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                if (lastSign == '+') {
                    st.push(num);
                    num = 0;
                    lastSign = c;
                } else if (lastSign == '-') {
                    st.push(-num);
                    num = 0;
                    lastSign = c;
                }
            }

        }

        int calc = 0;
        while (!st.isEmpty()) {
            calc += st.pop();
        }

        return calc;
    }
}