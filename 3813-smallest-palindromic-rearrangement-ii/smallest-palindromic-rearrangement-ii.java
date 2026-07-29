class Solution {

    public String smallestPalindrome(String s, int k) {
        int n = s.length();

        char mid = ' ';
        if (n % 2 == 1) {
            mid = s.charAt(n / 2);
        }

        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            if (n % 2 == 1 && i == n / 2)
                continue;
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            count[i] /= 2;
        }

        int half = n / 2;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < half; i++) {

            boolean placed = false;

            for (int j = 0; j < 26; j++) {

                if (count[j] == 0)
                    continue;

                count[j]--;

                int remaining = 0;
                for (int x = 0; x < 26; x++)
                    remaining += count[x];

                long ways = 1;

                for (int x = 0; x < 26; x++) {

                    if (count[x] == 0)
                        continue;

                    long comb = nCr(remaining, count[x], k);

                    ways = Math.min((long) k, ways * comb);

                    remaining -= count[x];

                    if (ways >= k)
                        break;
                }

                if (ways >= k) {
                    sb.append((char) ('a' + j));
                    placed = true;
                    break;
                }

                count[j]++;
                k -= ways;
            }

            if (!placed)
                return "";
        }

        StringBuilder rev = new StringBuilder(sb).reverse();

        if (mid != ' ')
            sb.append(mid);

        return sb.toString() + rev.toString();
    }

    private long nCr(int n, int r, int limit) {

        if (r < 0 || r > n)
            return 0;

        r = Math.min(r, n - r);

        long ans = 1;

        for (int i = 1; i <= r; i++) {
            ans = ans * (n - r + i) / i;

            if (ans >= limit)
                return limit;
        }

        return ans;
    }
}