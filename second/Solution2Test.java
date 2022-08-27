import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Solution2Test {
    
    @Test
    public void testSort(){
        int [] arr = new int[]{5,6,3,2,5,1,4,9};
        int [] sortedArray = new int[]{1, 2, 3, 4, 5, 5, 6, 9};
        Solution2 s = new Solution2();
        s.sortArr(arr);
        for(int i = 0; i < arr.length; i++){
            assertEquals(sortedArray[i], arr[i]);
        }
    }
}
