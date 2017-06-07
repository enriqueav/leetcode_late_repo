/*
not my most elegant solution
however
it works
*/
public class Solution {
    public void addIP(ArrayList<String> l,int init, String s,String soFar, int part){
        if( part == 5 && init==s.length() ){
           // if we ended the 4 parts, and finished the string
           l.add(soFar.substring(0,soFar.length()-1)); 
        } 
        
        StringBuilder sb = new StringBuilder();
        for(int i=init; i<s.length(); i++){
            char thisChar = s.charAt(i);
            sb.append(thisChar+"");
            
            // only recursively call if
            // 1. there is enough remaining digits to finish the remaining parts
            // 2. this number is not 0XX (i.e. 012)
            //     a. However, it can be 0.0.0.0
            // 3. the number formed so far is not more than 255
            if( (s.length()-i-1) >= (4-part) && 
               !( sb.length()>1 && sb.toString().substring(0,1).equals("0")) ){
                if( Integer.parseInt( sb.toString() ) <= 255 )
                    addIP(l,i+1,s,(soFar+sb.toString()+"."),part+1);
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> l = new ArrayList<String>();
        if(s == null || s.length()<4) return l;
        if(s.length() > 12 ) return l;
        addIP(l,0,s,"",1);
        return l;
    }
}
