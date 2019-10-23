package com.jing.dp;

import java.util.Stack;

/**
 * @Author: huangjingyan
 * @Date: 2019/10/20 18:53
 * @Version 1.0
 */
public class TheFrogJump {

    /**
     * LeetCode 403
     * 一只青蛙想要过河。 假定河流被等分为 x 个单元格，并且在每一个单元格内都有可能放有一石子（也有可能没有）。 青蛙可以跳上石头，但是不可以跳入水中。

     给定石子的位置列表（用单元格序号升序表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一个石子上）。 开始时， 青蛙默认已站在第一个石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格1跳至单元格2）。

     如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。

     请注意：

     石子的数量 ≥ 2 且 < 1100；
     每一个石子的位置序号都是一个非负整数，且其 < 231；
     第一个石子的位置永远是0。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/frog-jump
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int []stones = {0,1,3,5,6,8,12,17};
        System.out.println(canCross(stones));
    }

    public static boolean canCross(int []stones) {
        boolean flag = false;
        Stack<Item> stack = new Stack<Item>();
        int index = 0;
        //第一次的步长设为0
        int temp = 0;
        Item fistItem = new Item(index, temp, 0);
        stack.push(fistItem);
        int nextPath = 1;
        while(!stack.isEmpty()) {
            Item top = stack.peek();
            if(top.index == stones.length-1) {
                return true;
            }
            boolean find = false;
            for(int i=top.index+1;i<stones.length;i++) {
                if(stones[i] == nextPath+top.temp+stones[top.index]) {
                    stack.push(new Item(i, top.temp+nextPath, nextPath));
                    find = true;
                    break;
                }
            }
            if(!find) {
                Item item = stack.pop();
            }
            nextPath = top.path++;
        }
        return flag;
    }

    static class Item{
        private int index;
        private int temp;
        private int path;
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
        public int getTemp() {
            return temp;
        }
        public void setTemp(int temp) {
            this.temp = temp;
        }
        public int getPath() {
            return path;
        }
        public void setPath(int path) {
            this.path = path;
        }
        public Item(int index, int temp, int path) {
            super();
            this.index = index;
            this.temp = temp;
            this.path = path;
        }


    }
}
