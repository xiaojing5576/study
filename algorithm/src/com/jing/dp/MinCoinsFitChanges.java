package com.jing.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huangjingyan
 * @Date: 2019/9/1 12:01
 * @Version 1.0
 */
public class MinCoinsFitChanges {
    public static void main(String[] args) {
        int value[] = {2,6};
        int changes = 7;
        getMinCoins(value,changes);
    }

    private static void getMinCoins(int orignValue[],int changes){
        //填充第一位
        int value[] = new int[orignValue.length + 1];
        value[0] = 0;
        for(int i=1;i<value.length;i++){
            value[i] = orignValue[i-1];
        }
        int coinsNum = value.length;
        int [][]dp = new int[coinsNum][changes+1];
        int [][]use = new int[coinsNum][changes+1];
        for(int i=0;i < coinsNum;i++){
            dp[i][0] = 0;
            use[i][0] = 0;
        }
        for(int j=1;j <= changes;j++){
            dp[0][j] = Integer.MAX_VALUE;
            use[0][j] = 0;
        }
        for (int i=1;i< coinsNum;i++){
            for(int j=1;j<= changes;j++){
                if(value[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                    use[i][j] = 0;
                }else {
                    //遵循的策略为 dp[i][j] = min(dp[i-1][j],dp[i][j-value[i]]+1)
                    if (dp[i-1][j] > dp[i][j-value[i]]+1){
                        dp[i][j] = dp[i][j-value[i]]+1;
                        use[i][j] = 1;
                    }else{
                        //不使用当前硬币
                        dp[i][j] = dp[i-1][j];
                        use[i][j] = 0;
                    }
                }
            }
        }
        System.out.println(dp[orignValue.length][changes]);

        List<Integer> res = new ArrayList<>();
        int rest = changes;
        while (rest != 0){
            for(int i=value.length - 1;i>=1;i--){
                if(use[i][rest] == 1){
                    res.add(value[i]);
                    rest = rest - value[i];
                    break;
                }
            }

        }

        System.out.println(res);
        return;
    }
}
