/*
copied *from memory* from the CTCI algorithm
it worked!
*/
public class Solution {

    public void gp(ArrayList<String> l, int n,int opening,int closing,String soFar){
        if( soFar.length() == n*2 ) l.add(soFar);
        if( opening < n ) gp(l,n,opening+1,closing,soFar+"(");
        if( opening > closing ) gp(l,n,opening,closing+1,soFar+")");
    }
    
    public List<String> generateParenthesis(int n) {
        ArrayList<String> l = new ArrayList<String>();
        gp(l,n,0,0,"");
        return l;
    }
}
