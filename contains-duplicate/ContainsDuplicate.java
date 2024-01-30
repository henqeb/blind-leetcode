import java.util.HashSet;

public class ContainsDuplicate {

    public static void main(String[] args) {
        
    }

    public static boolean containsDuplicate(int[] nums) {
        var dupSet = new HashSet<Integer>();

        for (int num : nums) {
            if (dupSet.contains(num)) return true;
            else dupSet.add(num);
        }

        return false;
    }
}