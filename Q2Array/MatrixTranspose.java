package Q2Array;

public class MatrixTranspose {

    public int[][] Matrix_Transpose(int[][] matrix) {
        int[][] originalMatrix = matrix;
        //construct transpose matrix

        int[][] transMatrix = new int[originalMatrix[0].length][originalMatrix.length];

        for (int i = 0;i<originalMatrix[0].length;i++) {
            for (int j = 0;j<originalMatrix.length;j++) {

                transMatrix[i][j] = originalMatrix[j][i];

            }
        }
        return transMatrix ;
    }
    //to print transpose matrix
    public void printMatrix(int[][] Matrix) {
        for (int i = 0; i < Matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < Matrix[i].length; j++) {
                System.out.print(Matrix[i][j] + " ");

        }
    }
}
       public static void main(String[] args) {
        MatrixTranspose mt = new MatrixTranspose();
        int[][] matrix = {{3,4},{2,1}};
       mt.printMatrix(mt.Matrix_Transpose(matrix));
    }
}
