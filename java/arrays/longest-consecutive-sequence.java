/*
This is my crazy solution.
But it works, in n time.
Naturally I think it could be way shorter than this.
*/

public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,int []> m = new HashMap<Integer,int []>();
        int maxMancha = 0;
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            // this has been processed
            if( m.containsKey(n) ) 
                continue;
            else {
                // first on cluster, count, last on cluster 
                int[] values = {n,1,n};
                m.put(n,values);
                maxMancha = Math.max(maxMancha,1);
            }
            
            if( m.containsKey(n+1) && !m.containsKey(n-1) ){
                //exist only the next
                int[] valuesNext = m.get(n+1);
                // change initial
                valuesNext[0] = n;
                valuesNext[1]++;
                m.put(n,valuesNext);
                //m.put((n+1),valuesNext);
                m.put(valuesNext[2],valuesNext);
                maxMancha = Math.max(maxMancha,valuesNext[1]);
            } else if( m.containsKey(n-1) && !m.containsKey(n+1) ){
                //exist only the next
                int[] valuesPrev = m.get(n-1);
                // change initial
                valuesPrev[2] = n;
                valuesPrev[1]++; //increment count
                m.put(n,valuesPrev);
                //m.put((n-1),valuesPrev);
                m.put(valuesPrev[0],valuesPrev);
                maxMancha = Math.max(maxMancha,valuesPrev[1]);
            } else if( m.containsKey(n-1) && m.containsKey(n+1) ){
                int[] valuesPrev = m.get(n-1);
                int[] valuesNext = m.get(n+1);
                int newMancha = valuesPrev[1]+1+valuesNext[1];
                valuesPrev[2] = valuesNext[2];
                valuesNext[0] = valuesPrev[0];
                valuesPrev[1]=newMancha;
                valuesNext[1]=newMancha;
                maxMancha = Math.max(maxMancha,newMancha);
                m.put(valuesPrev[0],valuesPrev);
                m.put(valuesNext[2],valuesNext);
            } 
        }
        return maxMancha;
    }
}
