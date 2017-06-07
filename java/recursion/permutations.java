public class Solution {
 
    public void p(ArrayList<Integer> t, 
       ArrayList<List<Integer>> r, 
       ArrayList<Integer> s){
            // stop condition
            if( s.size() == 0 ) 
                r.add( new ArrayList<Integer>(t) );
            else {    
                for(int num : s){
                    // create a copy of the list, remove this item
                    ArrayList<Integer> temp = new ArrayList<Integer>(s);
                    if( temp.contains(new Integer(num)) ){
                        temp.remove(new Integer(num));
                        
                        // begin backtrack
                        t.add(num);
                        p(t,r,temp);
                        t.remove(new Integer(num)); 
                        //don't forget the backtrack!
                    }
                }
            }
       }
 
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> r = new ArrayList<List<Integer>>();
        ArrayList<Integer> s = new ArrayList<Integer>();
        for(int num : nums) s.add(num);
        p(new ArrayList<Integer>(),r,s);    
        return r;
    }
}
