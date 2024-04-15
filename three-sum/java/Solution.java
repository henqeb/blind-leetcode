import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        int[] input = {-1,0,1,2,-1,-4};
        var tripletList = threeSum(input);
        
        for (var triplet : tripletList) {
            int x = triplet.get(0);
            int y = triplet.get(1);
            int z = triplet.get(2);
            System.out.printf("(%d, %d, %d)\n", x, y, z);
        }
    }

    /**
     * Find three numbers x, y, z, where x != y && x!= y && y != z, such that these numbers add up to 0.
     * @param nums input array of numbers
     * @return List of triplets (also represented as lists).
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        var tripletSet = new HashSet<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int[] twoSumSearchSpace = copyInputArrayAfterIndex(nums, i);
            Stack<int[]> twoSumResult = twoSum(twoSumSearchSpace, -x);
            if (twoSumResult.empty()) continue;

            while (!twoSumResult.empty()) {
                int[] yz = twoSumResult.pop();
                int y = yz[0];
                int z = yz[1];

                if (!tripletSet.add(new ArrayList<Integer>(Arrays.asList(x, y, z))))
                    continue;
            }
        }

        var result = new ArrayList<>(tripletSet);

        return result;
    }

    public static int[] copyInputArrayAfterIndex(int[] inputArray, int index) {
        int[] result = new int[inputArray.length - (index+1)];
        for (int i = 0; i < result.length; i++) {
            int inputIndex = i + index + 1;
            result[i] = inputArray[inputIndex];
        }

        return result;
    }

    /**
     * Finds two numbers in input array that matches target value when added together.
     * @param nums input array of integers.
     * @param target target value which nums[i] + nums[j] must equal to.
     * @return int-array of size two containing indices of two numbers that add up to target.
     */
    public static Stack<int[]> twoSum(int[] nums, int target) {
        Stack<int[]> results = new Stack<>();
        var map = new HashMap<Integer, Integer>(); // <value, index>

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                results.push(new int[] { map.get(complement), nums[i] }); // TODO: gjennomgå tuple
                // TODO: map.put(nums[i], i) ??
            }
            else {
                map.put(nums[i], i);
            }
        }

        return results;
    }
}