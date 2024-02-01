class Solution {

    public static void main(String[] args) {
        int[] input = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(input));
    }

    private static int[] memo;
    
    public static int maxSubArray(int[] nums) {
        final int N = nums.length;
        memo = new int[N];
        memo[0] = nums[0]; // base case

        int currMax = nums[0];
        for (int i = 1; i < N; i++) {
            memo[i] = nums[i] + Math.max(0, memo[i-1]);
            if (memo[i] > currMax) currMax = memo[i];
        }

        return currMax;
    }

    // /**
    //  * Helper method for maxSubArray()
    //  * @param i recurrence counter
    //  * @return max sum of a subarray from input array
    //  */
    // public static int recursiveMaxSubArray(int[] nums, int[] memo, int i) {
    //     // base case
    //     if (i <= 0) {
    //         return nums[i];
    //     }
    //     return 

    // }
}