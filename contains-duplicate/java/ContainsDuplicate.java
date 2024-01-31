import java.util.HashSet;

public class ContainsDuplicate {

    public static void main(String[] args) {
        
    }

    /**
     * HashSet.add(..) returns true if element not already in set, false otherwise.
     * Because of this we only need one conditional: Simply check if the add operation was successful. 
     */
    public static boolean containsDuplicate(int[] nums) {
        var dupSet = new HashSet<Integer>();
        for (int num : nums) {
            if (!dupSet.add(num)) return true;
        }

        return false;
    }
}