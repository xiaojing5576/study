package com.jing.disjoint;

/**
 * @Author: huangjingyan
 * @Date: 2019/10/15 21:56
 * @Version 1.0
 */
public class SwimToTheEndPoint {


    /**
     * leetcode 778
     * @param args
     */
    public static void main(String[] args) {
        int array[][] = { {0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        System.out.println(getMinSwimTime(array));
    }

    public static int getMinSwimTime(int array[][]) {
        int rows = array.length;
        int cols = array[0].length;

        int parent[][] = initParent(rows, cols);
        int count = 0;
        while (parent[rows - 1][cols - 1] != parent[0][0]) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < parent.length; j++) {
                    if (i > 0 && j > 0) {
                        if (array[i][j] == array[i - 1][j]) {
                            join(parent, (i - 1) * cols + j, i * cols + j);
                        }
                        if (array[i][j] == array[i][j - 1]) {
                            join(parent, i * cols + j - 1, i * cols + j);
                        }
                    } else if (i == 0 && j > 0) {
                        if (array[i][j] == array[i][j - 1]) {
                            join(parent, i * cols + j - 1, i * cols + j);
                        }
                    } else if (i > 0 && j == 0) {
                        if (array[i][j] == array[i - 1][j]) {
                            join(parent, (i - 1) * cols + j, i * cols + j);
                        }
                    }
                }
            }
            if (parent[rows - 1][cols - 1] == parent[0][0]) {
                break;
            }
            count++;
            array = addWater(array, count);
        }

        return count;
    }

    public static int[][] initParent(int rows, int cols) {
        int parent[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                parent[i][j] = i * cols + j;
            }
        }
        return parent;
    }

    public static int[][] join(int[][] parent, int join, int needJoin) {
        int col = parent[0].length;
        int toMerge = parent[join / col][join % col];
        int needMerge = parent[needJoin / col][needJoin % col];
        parent[needJoin / col][needJoin % col] = parent[join / col][join % col];
        for (int i = 0; i < parent.length; i++) {
            for (int j = 0; j < parent[0].length; j++) {
                if (parent[i][j] == needMerge) {
                    parent[i][j] = toMerge;
                }
            }
        }
        return parent;
    }

    public static int[][] addWater(int array[][], int water) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] < water) {
                    array[i][j] = water;
                }
            }
        }
        return array;

    }
}