public class Solution {
    public boolean isPalindrome(int x) {
        if( x < 0 ) return false;
        if( x < 10 ) return true;
        int length = 1;
        long preinit = 1;
        while( (preinit*10)<=x ){
            length++;
            preinit *= 10;
        }
        int init = (int)preinit;
        int tmp = 0;
        int forBeg = 1;
        while( tmp < (length/2) ){
            int atEnd = (x/init)%10;
            int atBeg = (x/forBeg)%10;
            if( atEnd != atBeg ) return false;
            init   /= 10;
            forBeg *= 10;
            tmp++;
        }    
        return true;
    }
}
