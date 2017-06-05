public class Solution {
    public boolean isInMatrix(int[][] m,int col, int row){
        return (col>=0 && col<m[0].length && row>=0 && row<m.length);
    }
 
    public int[] afterUp(int[][] m,int col, int row){
        int[] c = {col,row};
        
        if( col < m[0].length-1 )
            c[0]++;
        else
            c[1]++;
 
        return c;
    }
 
    public int[] afterDown(int[][] m,int col, int row){
        int[] c = {col,row};
        
        if( row < m.length-1 )
            c[1]++;
        else
            c[0]++;
 
        return c;
    }
 
    public int[] findDiagonalOrder(int[][] matrix) {
        if( matrix == null ) return null;
        if( matrix.length == 0 ) return new int[0]; 
    
            boolean up = true;
        int row = 0;
        int col = 0;
        int toStore = matrix.length * matrix[0].length;
        int toStoreIndex = 0; // to change the index in which val is saved
        int[] retVal = new int[toStore];
 
        while( toStoreIndex < toStore ){
            retVal[toStoreIndex] = matrix[row][col];
            if( up ){
                if( isInMatrix(matrix,col+1,row-1) ){
                    // if we can continue going up
                    col++;
                    row--;
                } else {
                    // calculate next coordinate
                    int[] newCoor = afterUp(matrix,col,row);
                    col=newCoor[0];
                    row=newCoor[1];
                    up = false;
                }
            } else {
                // we are going down
                if( isInMatrix(matrix,col-1,row+1) ){
                    //if we can continue going down
                    col--;
                    row++;
                } else {
                    // calculate next coordinate
                    int[] newCoor = afterDown(matrix,col,row);
                    col=newCoor[0];
                    row=newCoor[1];
                    up = true;
                }
            }    
            toStoreIndex++;
        }
        return retVal;
    }
}
