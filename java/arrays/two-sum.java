/*
well, I got this in the first try, no syntax issues, no chars out of place
*/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if( nums == null ) return null;
        if( nums.length < 2 ) return null;
 
        int[] retVal = {-1,-1};
             HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            int thisNum = nums[i];
            if( m.containsKey(target-thisNum) ){
                retVal[0]=m.get(target-thisNum);
                retVal[1]=i;
            }
            m.put(thisNum,i);
        }
        return retVal;
    }
}
