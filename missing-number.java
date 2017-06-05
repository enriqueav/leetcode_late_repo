public class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int suma = 0;
        for(int a:nums) suma+=a;
        int expected = (n*(n+1))/2;
        return expected-suma;
    }
}
