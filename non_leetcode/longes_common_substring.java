
public class LongesCommonSubstring {

	public static String longestCommonSubstring(String s1, String s2){
		int l1 = s1.length();
		int l2 = s2.length();
		int[][] m = new int[l1][l2];
		int longestStart = 0;
		int longestSize = 0;
		
		for(int i=0; i<l1; i++){
			for(int j=0; j<l2; j++){
				if( s1.charAt(i)==s2.charAt(j) ){
					int prev=0;
					if(i>0&&j>0)
						prev=m[i-1][j-1];
					
					m[i][j] = prev+1;
					if( m[i][j] >  longestSize){
						longestSize = m[i][j];
						longestStart=i;
					}
				}
				
			}	
		}
		int temp = 0;
		
		StringBuilder sb = new StringBuilder();
		while(temp<longestSize){
			sb.append(s1.charAt(longestStart-temp));
			temp++;
		}
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		System.out.println("LCS="+longestCommonSubstring("qwertyuio","xcvbn"));
	}

}
