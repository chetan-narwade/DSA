class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(-1);
            } else {
                int sum = 0;
                while (st.peek() != -1) {
                    sum += st.pop();
                }
                st.pop();

                if (sum != 0)
                    st.push(2*sum);
                else
                    st.push(1);

            }
        }

        int res= 0;

        while(!st.isEmpty()){
            res = res+st.pop();
        }

        return res;
    }
}