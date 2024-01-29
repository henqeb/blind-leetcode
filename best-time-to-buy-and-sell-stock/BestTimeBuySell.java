public class BestTimeBuySell {

    public static void main(String[] args) {
        // int[] input = {7,1,5,3,6,4};
        int[] input = {3,2,6,5,0,3};
        System.out.println(maxProfit(input));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        
        return maxProfit;
    }
}