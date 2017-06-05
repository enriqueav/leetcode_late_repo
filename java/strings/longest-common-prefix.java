//https://leetcode.com/problems/longest-common-prefix/#/description
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // corner case
        if( strs.length == 0 ) return "";
        
        // the first string (or whatever other string) serves as a mask
        String molde=strs[0];
        // basically loop for all the strings, and check up to what point
        // is equal to the mask
        for( String s : strs ){
            // and another corner case
            if( s.equals("") ) return "";
            int i=0;
            for( i=0; (i<molde.length())&&(i<s.length()) ; i++){
                if( molde.charAt(i)!=s.charAt(i) )
                    break;
            }
            molde = molde.substring(0,i);
        }
        return molde;
    }
}
