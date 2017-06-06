/*
spent a lot of time 'dancing' with the corner cases
*/
public class Solution {
    public int myAtoi(String str) {
        if( str == null ) return 0;
        if( str.length() == 0 ) return 0;
        long soFar = 0;
        boolean negative = false;
        boolean positive = false;
        
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if( Character.isDigit(c) ){
                int toInt = Integer.parseInt(c+"");
                soFar *= 10;
                soFar += toInt;
                
                if( soFar>Integer.MAX_VALUE && !negative  ) 
                    return Integer.MAX_VALUE;
                if(  soFar==Integer.MAX_VALUE && negative )
                    return (int)soFar*-1;
                if(  soFar>Integer.MAX_VALUE && negative )
                    return Integer.MIN_VALUE;
            } else if( c == '-' ){
                if(positive||negative) return 0;
                negative = true; 
            } else if( c == '+' ){
                if( positive ) return 0;
                positive = true;
                if( negative ) return 0;
            } else if( c == ' '){
                if( soFar > 0 || (negative || positive) )
                    break;
            } else {
                // ERROR
                if( soFar != 0l ) break;
                return 0;
            }
        }
        if( negative ) soFar*=-1;
        return (int)soFar;
    }
}
