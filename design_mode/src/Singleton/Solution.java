package Singleton;

/**
 * @Author: huangjingyan
 * @Date: 2019/8/9 20:39
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        subSolution subSolution = new subSolution();
        int height[] = {4,2,3};
        int result = subSolution.trap(height);
        System.out.println(result);
    }
}
class subSolution {
    public int trap(int[] height) {
        int sum = 0;

        for(int i = 0;i<height.length -1;i++){
            int sub = 0;
            for(int j = i+1;j<height.length;j++){
                if(height[i]>height[j]){
                    sub += height[i]-height[j];
                }
                else if(height[i] <= height[j]){
                    sum += sub;
                    i=j - 1;
                    break;
                }
            }
        }
        return sum;
    }
}
