/*
first approach, using a HashMap
*/
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        // map the index where the element is places <number,index>
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for( int index=0; index<nums.length; index++ ){
            hm.put( nums[index] , index );
        }
        int[] retVal = new int[findNums.length];
        for( int index=0; index<findNums.length; index++ ){
            int val = -1;
            int thisVal = findNums[index];
            for( int s=(hm.get(thisVal)+1) ; s<nums.length; s++ ){                
                if( nums[s]>thisVal ){
                    val = nums[s];
                    break;
                }
            }
            retVal[index]=val;
        }
        return retVal;        
    }
}
