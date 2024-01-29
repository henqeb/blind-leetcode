public class BestTimeBuySell {

    public static void main(String[] args) {
        int[] input = {7,1,5,3,6,4};
        // int[] input = {3,2,6,5,0,3};
        System.out.println(maxProfit(input));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int maxIndex = 0, minIndex = 0;
        for (int i = 0; i < prices.length; i++) {
            int currentProfit = prices[i] - prices[minIndex];
            if (prices[i] > prices[minIndex] && currentProfit > maxProfit) {
                maxProfit = prices[i] - prices[minIndex];
            }

            if (prices[i] > prices[maxIndex]) {
                maxIndex = i;
            }
            else if (prices[i] < prices[minIndex]) {
                minIndex = i;
                maxIndex = i; // move up because of "buy in future" constraint
            }
        }
        
        return maxProfit;
    }
}