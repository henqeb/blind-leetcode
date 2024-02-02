import java.util.List;
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

        int x, y, z;
        int[] twoSumSearchSpace;
        int[] twoSumResult;
        for (int i = 0; i < nums.length; i++) {
            x = nums[i];
            twoSumSearchSpace = copyInputArrayAfterIndex(nums, i);
            twoSumResult = twoSum(twoSumSearchSpace, -x);
            if (twoSumResult == null) continue;
            
            // found y + z = -x, meaning  x + y + z = 0
            y = twoSumResult[0];
            z = twoSumResult[1];
            if (x == y && y == z) continue;
            
            // detect duplicate triplet
            if (!tripletSet.add(new ArrayList<Integer>(Arrays.asList(x, y, z)))) {
                continue;
            }
        }

        var result = new ArrayList<>(tripletSet);

        return result;
    }

    public static int[] copyInputArrayAfterIndex(int[] inputArray, int index) {
        int[] result = new int[inputArray.length - (index+1)];
        int copyIndex;
        int inputIndex;
        for (int i = 0; i < result.length; i++) {
            inputIndex = i + index + 1;
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
    public static int[] twoSum(int[] nums, int target) {
        int[] result = null;
        var map = new HashMap<Integer, Integer>(); // <value, index>

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                result = new int[] { map.get(complement), i };
                break;
            }
            else {
                map.put(nums[i], i);
            }
        }

        return result;
    }
}