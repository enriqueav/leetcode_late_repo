/*
I have done that in other sites
*/
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            char thisChar = s.charAt(i);
            if( thisChar=='(' ||
                thisChar=='[' ||
                thisChar=='{' ){
                stack.push(thisChar);
            } else if( thisChar==')' || thisChar==']' || thisChar=='}' ){
                if( stack.isEmpty() ) return false;
                char poped = stack.pop();
                if( thisChar==')' && poped != '(' ) return false;
                if( thisChar==']' && poped != '[' ) return false;
                if( thisChar=='}' && poped != '{' ) return false;
            } else {
                return false; //should not get here
            }
        }
        if( !stack.isEmpty() ) return false;
        return true;
    }
}
