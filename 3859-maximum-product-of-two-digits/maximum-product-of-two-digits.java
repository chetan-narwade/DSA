class Solution {
    public int maxProduct(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        while (n != 0) {
            int rem = n % 10;
            n /= 10;
            pq.offer(rem);
        }

        int first = pq.poll();
        int second = pq.poll();  

        return first * second;
    }
}