public class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i1,i2;
        for( i1=num1.length()-1,i2=num2.length()-1 ; i1>=0&&i2>=0; i1--,i2-- ){
            int n1 = Integer.parseInt( num1.charAt(i1)+"" );
            int n2 = Integer.parseInt( num2.charAt(i2)+"" );
            int r = n1+n2+carry;
            if( r>=10 ){
                carry = 1;
                r = r-10;
            } else {
                carry = 0;
            }
            sb.append(r+"");
        }   
        while(i1>=0){
            int n1 = Integer.parseInt( num1.charAt(i1)+"" );
            int r = n1+carry;
            if( r>=10 ){
                carry = 1;
                r = r-10;
            } else { 
                carry = 0;
            }
            sb.append(r+"");
            i1--;
        } 
            
        while(i2>=0){
            int n2 = Integer.parseInt( num2.charAt(i2)+"" );
            int r = n2+carry;
            if( r>=10 ){
                carry = 1;
                r = r-10;
            } else { 
                carry = 0;
            }
            sb.append(r+"");
            i2--;
        }            
        
        if( carry > 0 ) sb.append(carry+"");
        return sb.reverse().toString();
    }
}
