/*
secon approach,
properly,
not using strings
*/
public class Solution {
    public int reverse(int x) {
        long soFar = 0;
        while( x != 0 ){
            soFar *= 10;
            soFar += x%10;
            x = (x-(x%10))/10;
            if( soFar > Integer.MAX_VALUE || soFar < Integer.MIN_VALUE ) return 0;
        }
        return (int)soFar;
    }
}
