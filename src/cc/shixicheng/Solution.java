package cc.shixicheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
        Problem
        Vestigium means "trace" in Latin. In this problem we work with Latin squares and matrix traces.

        The trace of a square matrix is the sum of the values on the main diagonal (which runs from the upper left to the lower right).

        An N-by-N square matrix is a Latin square if each cell contains one of N different values, and no value is repeated within a row or a column. In this problem, we will deal only with "natural Latin squares" in which the N values are the integers between 1 and N.

        Given a matrix that contains only integers between 1 and N, we want to compute its trace and check whether it is a natural Latin square. To give some additional information, instead of simply telling us whether the matrix is a natural Latin square or not, please compute the number of rows and the number of columns that contain repeated values.

        Input
        The first line of the input gives the number of test cases, T. T test cases follow. Each starts with a line containing a single integer N: the size of the matrix to explore. Then, N lines follow. The i-th of these lines contains N integers Mi,1, Mi,2 ..., Mi,N. Mi,j is the integer in the i-th row and j-th column of the matrix.

        Output
        For each test case, output one line containing Case #x: k r c, where x is the test case number (starting from 1), k is the trace of the matrix, r is the number of rows of the matrix that contain repeated elements, and c is the number of columns of the matrix that contain repeated elements.

        Limits
        Test set 1 (Visible Verdict)
        Time limit: 20 seconds per test set.
        Memory limit: 1GB.
        1 ≤ T ≤ 100.
        2 ≤ N ≤ 100.
        1 ≤ Mi,j ≤ N, for all i, j.

        Sample

        Input

        Output

        3
        4
        1 2 3 4
        2 1 4 3
        3 4 1 2
        4 3 2 1
        4
        2 2 2 2
        2 3 2 3
        2 2 2 3
        2 2 2 2
        3
        2 1 3
        1 3 2
        1 2 3


        Case #1: 4 0 0
        Case #2: 9 4 4
        Case #3: 8 0 2


        In Sample Case #1, the input is a natural Latin square, which means no row or column has repeated elements. All four values in the main diagonal are 1, and so the trace (their sum) is 4.

        In Sample Case #2, all rows and columns have repeated elements. Notice that each row or column with repeated elements is counted only once regardless of the number of elements that are repeated or how often they are repeated within the row or column. In addition, notice that some integers in the range 1 through N may be absent from the input.

        In Sample Case #3, the leftmost and rightmost columns have repeated elements.
**/

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        List<int[][]> squares = new ArrayList(caseNum);
        // resolve case info data
        for (int i = 0; i < caseNum; i++) {
            int squareLength = sc.nextInt();
            int[][] square = new int[squareLength][squareLength];
            squares.add(square);
            // resolve square data
            for (int squareX = 0; squareX < squareLength; squareX++) {
                for (int squareY = 0; squareY < squareLength; squareY++) {
                    square[squareX][squareY] = sc.nextInt();
                }
            }
        }
        for (int i = 0; i < squares.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + trace(squares.get(i)) + " " + rowRepeated(squares.get(i)) + " " + columnRepeated(squares.get(i)));
        }
    }

    static int trace(int[][] square) {
        int traceValue = 0;
        for (int i = 0; i < square.length; i++) {
            traceValue += square[i][i];
        }
        return traceValue;
    }

    static int rowRepeated(int[][] square) {
        int rowRepeated = 0;
        for (int x = 0; x < square.length; x++) {
            List<Integer> rows = new ArrayList<>(square.length);
            for (int y = 0; y < square.length; y++) {
                if (rows.contains(square[x][y])) {
                    rowRepeated++;
                    break;
                }
                rows.add(square[x][y]);
            }
        }
        return rowRepeated;
    }

    static int columnRepeated(int[][] square) {
        int columnRepeated = 0;
        for (int y = 0; y < square.length; y++) {
            List<Integer> rows = new ArrayList<>(square.length);
            for (int x = 0; x < square.length; x++) {
                if (rows.contains(square[x][y])) {
                    columnRepeated++;
                    break;
                }
                rows.add(square[x][y]);
            }
        }
        return columnRepeated;
    }

    void printSquares(List<int[][]> squares) {
        squares.stream().forEach(square -> {
            for (int x = 0; x < square.length; x++) {
                for (int y = 0; y < square[x].length; y++) {
                    System.out.print(square[x][y] + " ");
                }
                System.out.println("");
            }
        });
    }

}