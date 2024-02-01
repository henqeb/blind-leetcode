class Solution {

    public static void main(String[] args) {
        int[] input = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(input));
    }
    
    /**
     * Linear time version. Keeps track of the largest sum encountered while iterating.
     * If there exists a negative number so large such that the sum will be negative, reset sum to 0 to avoid
     * decrementing the largest maximum value found so far.
     */
    public static int maxSubArray(int[] nums) {
        int currMax = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            currMax = Math.max(currMax, sum);
            sum = Math.max(sum, 0); // avoiding negative sums
        }

        return currMax;
    }
}