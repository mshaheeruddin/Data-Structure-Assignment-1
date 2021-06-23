package Q7AlgorithmAnalysis;
import java.io.*;
import java.sql.Time;
import java.util.Scanner;

public class UnimodalSequence {
    int returnTop(int[] sequence, int firstIndex, int lastIndex) {
        //Apply Binary search

        while (lastIndex > firstIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (sequence[middleIndex] < sequence[middleIndex+1]) {
                    firstIndex = middleIndex + 1;
            }
            else if (sequence[middleIndex] > sequence[middleIndex+1]) {
                     lastIndex = middleIndex;
            }
        }
        System.out.print("Top is: ");
         return  sequence[firstIndex];
    }



    public static void main(String[] args) {
        UnimodalSequence uniSeq = new UnimodalSequence();
        Scanner in = new Scanner(System.in);
        int[] seq = {1,3,5,9,4,1};
        System.out.println(uniSeq.returnTop(seq,0,seq.length-1));

    }
}
