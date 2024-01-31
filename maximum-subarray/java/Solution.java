class Solution {

    public static void main(String[] args) {
        int[] input = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(input));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        final int N = nums.length;
        int[] memo = new int[N];
        memo[0] = 0;
        
        for (int j = 1; j < N; j++) {
            int[] subarray = new int[j];
            // copy i elements from input array to temporary subarray
            memo[j] = Math.max(sum(subarray), memo[j-1]);
        }

        return memo[N-1];
    }

    public static int sum(int[] intArray) {
        int sum = 0;
        for (int i = 0; i < intArray.length; i++) {sum += intArray[i];}
        return sum;
    }
}