import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

public class TwoSum {

    public static void main(String[] args) {
        int[] input = {-1,-2,-3,-4,-5};
        // int[] input = {2,7,11,15};
        int target = -8;

        int[] solution = twoSum(input, target);
        for (int i : solution)
            System.out.printf("%d ", i);
    }

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

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}