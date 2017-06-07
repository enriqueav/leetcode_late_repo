/*
This is awesome.
Compiled and worked the first time.
*/

public class Solution {
    public void sh(ArrayList<List<Integer>> r, ArrayList<Integer> soFar, int[] nums,int init){
        if( soFar.size()>0 )
            r.add(new ArrayList<Integer>(soFar));
        
        for(int i=init;i<nums.length; i++){
            soFar.add(nums[i]);
            sh(r,soFar,nums,i+1);
            soFar.remove(new Integer(nums[i]));
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> r = new ArrayList<List<Integer>>();
        r.add( new ArrayList<Integer>() ); // the empty is always there
        if( nums == null || nums.length==0 ) return r;
        sh(r,new ArrayList<Integer>(),nums,0);
        return r;
    }
}
