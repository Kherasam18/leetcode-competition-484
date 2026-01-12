public class Question4 {
    public int maximumAND(int[] nums, int k, int m) {
        int[] arr = nums;
        long maxOps = k;
        int res = 0;
        long[] costs = new long[arr.length];

        for (int i = 30; i >= 0; i--) {
            int target = res | (1 << i);
            if (canFormSubset(arr, costs, maxOps, m, target))
                res = target;

        }
        return res;
    }

    private boolean canFormSubset(int[] nums, long[] costs, long k, int m, int target) {
        for (int i = 0; i < nums.length; i++)
            costs[i] = getCost(nums[i], target);

        Arrays.sort(costs);

        long totalCost = 0;
        for (int i = 0; i < m; i++) {
            totalCost += costs[i];
            if (totalCost > k)
                return false;

        }
        return true;
    }

    private long getCost(int val, int target) {
        long curr = val;
        long cost = 0;

        for (int i = 30; i >= 0; i--) {
            boolean targetBit = ((target >> i) & 1) == 1;
            boolean currentBit = ((curr >> i) & 1) == 1;
            if (targetBit && !currentBit) {
                long mask = (1L << i) - 1;
                long remainder = curr & mask;
                long increment = (1L << i) - remainder;
                curr += increment;
                cost += increment;
            }
        }
        return cost;
    }
}
