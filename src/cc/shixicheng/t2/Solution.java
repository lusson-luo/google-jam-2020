package cc.shixicheng.t2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        List<int[][]> nums = new ArrayList(caseNum);
        // resolve case info data
        for (int i = 0; i < caseNum; i++) {
            int squareLength = sc.nextInt();
            int[][] num = new int[squareLength][squareLength];
            nums.add(num);
            // resolve num data
            for (int nameX = 0; nameX < squareLength; nameX++) {
                for (int numY = 0; numY < squareLength; numY++) {
                    num[nameX][numY] = sc.nextInt();
                }
            }
        }
    }
}
