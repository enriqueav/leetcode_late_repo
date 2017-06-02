/*
This may need a lot of re-work.
It was just the first solution I found to be accepted.
I particularly don't like the use of StringBuilder.

Also, I am not 100% sure about Stack
*/
public class Solution {
    public String repeat(Stack<Character> stack){
        StringBuilder sb = new StringBuilder();
        char c = stack.pop();
        sb.append(c+"");
        while( true ){
            char t = stack.pop();
            if( t != '[' )
                sb.append(t+"");
            else
                break;
        }
        StringBuilder numberString = new StringBuilder();
        char n = stack.pop();
        numberString.append(n+"");
    
        while( stack.size() > 0 && Character.isDigit(stack.peek()) ){
            numberString.append(stack.pop()+"");
        }
        
        int multiplier = Integer.parseInt(numberString.reverse().toString());
        StringBuilder multiplied = new StringBuilder();
        String toAppend = sb.reverse().toString();
        for(int i=0; i<multiplier; i++){
            multiplied.append(toAppend);
        }
        return multiplied.toString();
    }
    public String decodeString(String s) {
        Stack<Character> expresion = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if( c == ']'){
                //do the math
                String toAdd = repeat(expresion);
                for(int w=0; w<toAdd.length(); w++)
                    expresion.push(toAdd.charAt(w));
            } else {
                // is normal letter
                expresion.push(c);
            }
            
        }
        StringBuilder toReverse = new StringBuilder();
        while( !expresion.isEmpty() ){
            toReverse.append(expresion.pop()+"");
        }
        return toReverse.reverse().toString();
    }
}
