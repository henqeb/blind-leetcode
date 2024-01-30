public class Solution {

    public static void main(String[] args) {
        productExceptSelf(new int[]{1, 2, 3, 4});
    }

    /*
     * 
     */
    public static int[] productExceptSelf(int[] nums) {
        final int N = nums.length;
        int[] products = new int[N];
        
        // products from left to right
        int[] prefixProducts = new int[N];
        int prod = 1;
        for (int i = 0; i < N; i++) {
            prefixProducts[i] = prod;
            prod *= nums[i];
        }

        // products from right to left
        int[] suffixProducts = new int[N];
        prod = 1;
        for (int i = N - 1; i >= 0; i--) {
            suffixProducts[i] = prod;
            prod *= nums[i];
        }

        // multiplying across pre-/suffix products to get result
        for (int i = 0; i < N; i++) {
            products[i] = prefixProducts[i] * suffixProducts[i];
        }

        return products;
    }
}