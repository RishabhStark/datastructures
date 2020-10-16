package graphs;

public class FloodFill {

    public static void floodFill(int matrix[][],int i,int j,int toFill,int prevFill) {
        //DFS
        int m=matrix.length;
        int n=matrix[0].length;
        if(i<0 || j<0) return;
        else if(i>=m || j>=n) return;
        else if(prevFill!=matrix[i][j]) return;
       matrix[i][j]=toFill;
       floodFill(matrix,i-1,j,toFill,prevFill);
       floodFill(matrix,i+1,j,toFill,prevFill);
       floodFill(matrix,i,j-1,toFill,prevFill);
       floodFill(matrix,i,j+1,toFill,prevFill);

    }

}
