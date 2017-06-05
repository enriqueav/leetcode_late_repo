public class Solution {
    public boolean binarySearch(int[] row,int target, int ini, int end){
        if( ini > end ) return false;
        
        int mid = (ini+end)/2;
        
        if( row[mid] == target ) 
            return true;
        else if( row[mid] > target )
            return binarySearch(row, target, ini, mid-1);
        else
            return binarySearch(row, target, mid+1, end);
    }
    
    public int findRowBinary(int[][] matrix,int target, int ini,int end){
        // TODO is there any scape condition?
        if( ini > end ) return -1;
        
        int mid = (ini+end)/2;
        if( matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length-1] ){
            return mid;
        } else if( matrix[mid][0] > target ){
            return findRowBinary(matrix,target,ini,mid-1);
        } else  {//if( matrix[mid][0] < target ){
            return findRowBinary(matrix,target,mid+1,end);
        }
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if( matrix.length==0 || matrix[0].length==0 ) return false;
        // if value is smaller than first or greater than last
        if( target < matrix[0][0] || target>matrix[matrix.length-1][matrix[0].length-1]) return false;
        int findRow = findRowBinary(matrix,target,0,matrix.length-1);
        if( findRow == -1 ) 
            return false;
        else
            return binarySearch(matrix[findRow], target, 0, matrix[findRow].length);
    }
}
