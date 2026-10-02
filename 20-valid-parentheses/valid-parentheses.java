class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char start = s.charAt(i);
            if (start == '{' || start == '(' || start == '[') {
                st.push(start);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                char end = st.pop();
                if ((start == '}' && end == '{') || (start == ')' && end == '(') || (start == ']' && end == '[')) {
                   continue;
                } else {
                    return false;
                }
            }

        }
        return st.isEmpty();
    }
}