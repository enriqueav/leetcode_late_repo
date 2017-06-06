/*
I had this half-backed.
It only needed a change in a sign, sigh...
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if( s == null ) return 0;
        if( s.length() == 0 ) return 0;
 
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        int maxLength = 0;
        int thisLength = 0;
        int initial = 0;
        for( int f=0; f<s.length(); f++ ){
            Character c = s.charAt(f);
            if(hm.containsKey(c)){
                for( int i=initial; i<hm.get(c); i++) 
                    hm.remove(s.charAt(i));
            
                initial = hm.get(c)+1;
                hm.put(c,f);
            } else {
                hm.put(c,f);
                maxLength = Math.max( maxLength,(f-initial+1) );
            }
        }    
        return maxLength;
    }
}
