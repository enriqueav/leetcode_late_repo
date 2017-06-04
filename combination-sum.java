/*
first version
not-so-elegant solution
should be easier to track the path
*/
public class Solution {

    ArrayList<List<Integer>> res;
    public void sums(int[] candidates, int target, int ci,String path){
        if( 0 == target ){
            String[] chars = path.trim().split(" ");
            ArrayList<Integer> thisPath = new ArrayList<Integer>();
            for( String n : chars ) thisPath.add( Integer.parseInt(n) );
            res.add(thisPath);
        }
        while( ci<candidates.length && candidates[ci]<=target  ){
            sums(candidates,(target-candidates[ci]),ci,path+" "+candidates[ci]);
            ci++;
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<List<Integer>>();
        if( candidates.length > 0 ){
            Arrays.sort(candidates);
            sums(candidates,target,0,"");
        }
        return res;
    }
}
