import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        int[] input = {-1,0,1,2,-1,-4};
        int[] testCopy = copyInputArrayAfterIndex(input, 0);
        for (int num : testCopy) System.out.printf("%d ", num);
    }

    /**
     * Find three numbers x, y, z, where x != y && x!= y && y != z, such that these numbers add up to 0.
     * @param nums input array of numbers
     * @return List of triplets (also represented as lists).
     */
    public List<List<Integer>> threeSum(int[] nums) {
        var tripletSet = new HashSet<List<Integer>>();

        int x, y, z;
        for (int i = 0; i < nums.length; i++) {
            x = nums[i];

        }

        return null;
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