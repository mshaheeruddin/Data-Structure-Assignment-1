package Q3ImageBlurring;

public class ImageBlurring {

    public float[][] imageBlurring(float[][] imagepixels) {
        //temporary variable
        float[][] copy = new float[imagepixels.length][imagepixels[0].length];

        for (int i = 0; i < imagepixels.length; i++) {
            for (int j = 0; j < imagepixels[0].length; j++) {
                copy[i][j] = imagepixels[i][j];
            }
        }

        for (int i = 0; i < imagepixels.length; i++) {
            for (int j = 0; j < imagepixels[0].length; j++) {
                //Corner CASES

                // top left corner case
                if (i == 0 && j == 0) {
                    float avg = ((float) copy[i][j + 1] + copy[i + 1][j] + copy[i][j]) / 3;
                    imagepixels[i][j] = avg;

                }
                //top right case
                else if (i == 0 && j == imagepixels.length - 1) {

                    float avg = ((float) copy[i][j - 1] + copy[i + 1][j] + copy[i][j]) / 3;
                    imagepixels[i][j] = avg;


                }
                //bottom left corner case
                else if (j == 0 && i == imagepixels[0].length - 1) {
                    float avg = ((float) copy[i - 1][j] + copy[i][j + 1] + copy[i][j]) / 3;

                    imagepixels[i][j] = avg;

                }
                //bottom right corner
                else if (i == imagepixels[0].length - 1 && j == imagepixels.length - 1) {
                    float avg = ((float) copy[i - 1][j] + copy[i][j - 1] + copy[i][j]) / 3;

                    imagepixels[i][j] = avg;

                }
                //Edge CASES

                //Top edge
                else if (i == 0 && j != imagepixels[0].length - 1 && j != 0) {
                    float avg = ((float) copy[i][j + 1] + copy[i][j - 1] + copy[i + 1][j] + copy[i][j]) / 4;
                    imagepixels[i][j] = avg;

                }
                //Right edge
                else if (i != 0 && i != imagepixels[0].length - 1 && j == imagepixels.length - 1) {
                    float avg = ((float) copy[i - 1][j] + copy[i + 1][j] + copy[i][j - 1] + copy[i][j]) / 4;
                    imagepixels[i][j] = avg;
                }
                //bottom edge

                else if (i == imagepixels[0].length - 1 && j != 0 && j != imagepixels.length - 1) {
                    float avg = ((float) copy[i][j + 1] + copy[i][j - 1] + copy[i - 1][j] + copy[i][j]) / 4;
                    imagepixels[i][j] = avg;

                }
                // left edge
                else if (i != 0 && i != imagepixels[0].length - 1 && j == 0) {
                    float avg = ((float) copy[i - 1][j] + copy[i + 1][j] + copy[i][j + 1] + copy[i][j]) / 4;
                    imagepixels[i][j] = avg;
                } else {
                    float avg = ((float) copy[i + 1][j] + copy[i][j - 1] + copy[i - 1][j] + copy[i][j + 1] + copy[i][j]) / 5;
                    imagepixels[i][j] = avg;


                }

            }
        }

        return  imagepixels;
    }
    void display(float[][] matrix) {
        System.out.println("Output B:");
        matrix = imageBlurring(matrix);
        for (int i = 0; i < matrix.length; i++){
            System.out.println();
        for (int j = 0; j < matrix[i].length; j++) {
            System.out.printf("%.02f %s",matrix[i][j] , " " );
              }
          }
    }

    public static void main(String[] args) {
        ImageBlurring ib = new ImageBlurring();
        float[][] array2d =  { { 10,10,10,10,10},
                { 20,20,20,20,20 },
                { 80,80,80,80,80 },
                { 60,60,60,60,60 },
                { 70,70,70,70,70 } };
        ib.display(array2d);
    }
}
