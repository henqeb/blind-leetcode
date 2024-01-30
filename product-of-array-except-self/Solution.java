public class Solution {

    public static int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                product *= nums[j];
            }
            products[i] = product;
        }

        return products;
    }
}