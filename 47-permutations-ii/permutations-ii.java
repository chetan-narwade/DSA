class Solution {
    public List<List<Integer>> permuteUnique(int[] arr) {
        ArrayList<List<Integer>> ds = new ArrayList<>();

        Arrays.sort(arr);
        f(arr, 0, ds);

        return ds;
    }

    public static void f(int[] arr, int idx, ArrayList<List<Integer>> ds) {

        if (idx == arr.length) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int x : arr) {
                list.add(x);
            }

            ds.add(list);
            return;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = idx; i < arr.length; i++) {

            // Same value already chosen at this level
            if (set.contains(arr[i])) {
                continue;
            }

            set.add(arr[i]);

            swap(idx, i, arr);

            f(arr, idx + 1, ds);

            swap(idx, i, arr);
        }
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}