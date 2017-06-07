/*
well this is kind of a hack
reused the solution for permutation
just that is a hashset instead of an arraylist
at the end I convert the hashset to a proper arraylist
*/
public class Solution {
 
    public void p(ArrayList<Integer> t, 
       HashSet<List<Integer>> r, 
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
                        t.remove(t.size()-1); 
                        //don't forget the backtrack!
                    }
                }
            }
       }
 
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> r = new HashSet<List<Integer>>();
        ArrayList<Integer> s = new ArrayList<Integer>();
        for(int num : nums) s.add(num);
        p(new ArrayList<Integer>(),r,s);   
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        for(List<Integer> lista : r )
            res.add(lista);
        return res;
    }
}
