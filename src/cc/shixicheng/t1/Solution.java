package cc.shixicheng.t1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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