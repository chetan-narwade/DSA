class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        List<String> result = new ArrayList<>();
        q.add(s);
        vis.add(s);
        boolean found = false;
        if (s == null) return result;
        while (!q.isEmpty()) {
            String curr = q.poll();

            if (isValid(curr)) {
                result.add(curr);
                found = true;
            }

            if (found)
                continue;

            for (int i = 0; i < curr.length(); i++) {
                char c = curr.charAt(i);
        
                if (c != '(' && c != ')') continue;

                String next = curr.substring(0, i) + curr.substring(i + 1);
                if (!vis.contains(next)) {
                    q.add(next);
                    vis.add(next);
                }
            }
        }
        return result;
    }
   private static boolean isValid(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') count++;
            else if (ch == ')') {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}