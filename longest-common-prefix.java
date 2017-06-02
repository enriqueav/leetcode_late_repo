//https://leetcode.com/problems/longest-common-prefix/#/description
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if( strs.length == 0 ) return "";
        
        String molde=strs[0];
        for( String s : strs ){
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
