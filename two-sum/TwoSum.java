import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

public class TwoSum {

    public static void main(String[] args) {
        int[] input = { 3, 3 };
        int target = 6;

        int[] solution = twoSum(input, target);
        for (int i : solution)
            System.out.printf("%d ", i);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = null;
        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsValue(nums[i])) {
                // stop and get index
                int matchingIndex = getKeyByValue(map, nums[i]);
                // update result array
                result = new int[] { matchingIndex, i };
                break;
            } else {
                map.put(i, Math.abs(nums[i] - target));
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