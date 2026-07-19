class Solution {
    public String removeDuplicateLetters(String s) {
           boolean[] vis = new boolean[26];
        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (vis[ch - 'a']) continue;

            while (sb.length() > 0 &&
                   sb.charAt(sb.length() - 1) > ch &&
                   i < last[sb.charAt(sb.length() - 1) - 'a']) {

                vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(ch);
            vis[ch - 'a'] = true;
        }

        return sb.toString();
    }
}