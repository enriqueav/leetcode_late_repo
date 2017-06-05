/*
final version
implemented properbacktracking
key points 
    -add a copy to the res using 
        res.add(new ArrayList<Integer>(path));
    1. path.add the candidate
    2. call sums
    3. remove the last element in path
*/
public class Solution {

    ArrayList<List<Integer>> res;
    public void sums(int[] candidates, int target, int ci,ArrayList<Integer> path){
        if( 0 == target ){
            // make a copy!
            res.add(new ArrayList<Integer>(path));
        }
        while( ci<candidates.length && candidates[ci]<=target  ){
            path.add(candidates[ci]);
            sums(candidates,(target-candidates[ci]),ci,path);
            path.remove(path.size()-1);
            //dear lord, this does not work because it may multiple instances
            // path.remove(candidates[ci]);  
            ci++;
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<List<Integer>>();
        if( candidates.length > 0 ){
            Arrays.sort(candidates);
            sums(candidates,target,0,new ArrayList<Integer>());
        }
        return res;
    }
}
