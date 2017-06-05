/*
I did not create this algo
I just translated it from a phyton solution posted
I had the idea of binary search but did not implement it correctly :(
*/
public class Solution {
    public int findDuplicate(int[] nums){
        int low = 1;
        int high = nums.length-1;
        
        while( low < high ){
            int mid = low+(high-low)/2;
            int count = 0;
            for(int i:nums){
                if ( i <= mid )
                    count++;
            }
            if (count <= mid )
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }
}
