package com.jing.dfs;

public class WildcardMatching{
    public static void main(String[] args) {
        System.out.println(isMatch("a",""));
    }

    static class Node{
        //匹配字符串开始索引
        Integer startIndex;
        //匹配字符串结束索引
        Integer minLength;
        //自身索引
        Integer selfIndex;

        public Integer getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(Integer startIndex) {
            this.startIndex = startIndex;
        }

        public Integer getMinLength() {
            return minLength;
        }

        public void setMinLength(Integer minLength) {
            this.minLength = minLength;
        }

        public Integer getSelfIndex() {
            return selfIndex;
        }

        public void setSelfIndex(Integer selfIndex) {
            this.selfIndex = selfIndex;
        }
    }

    //使用栈来实现
    public static boolean isMatch(String s, String p) {
        if(s==null ||s.length() == 0){
            return allIsStar(p);
        }
        Stack<Node> stack = new Stack<>();
        //找到第一个栈元素
        int index = 0;
        Node first = getMatch(s,p,index,0,0);
        if(first == null){
            first = getMatch(s,p,index,0,1);
        }
        //第一个匹配不上
        if(first == null){
            return false;
        }
        index ++;
        stack.push(first);
        int startIndex = first.getStartIndex()+first.getMinLength();
        int minlength = 0;
        while(index >= 0 && startIndex < s.length()){
            Node node = null;
            while (node == null && index < p.length() && startIndex+minlength <= s.length()){
                node = getMatch(s,p,index,startIndex, minlength);
                minlength ++;
                if(node != null){
                    stack.push(node);
                    index ++;
                    break;
                }
            }
            //本次循环依然没有找到合适的node，说明上个push进栈的node截取长度不合适
            if(node == null){
                //已经没有元素，也找不到元素了
                if(stack.isEmpty()){
                    return false;
                }
                Node unfit = stack.pop();
                startIndex = unfit.getStartIndex();
                minlength = unfit.getMinLength()+1;
                index = unfit.getSelfIndex();
            }else {
                minlength = 0;
                startIndex = node.getStartIndex() + node.getMinLength();
                //是否已经可以结束
                if(startIndex == s.length() && (index == p.length() || allIsStar(p.substring(index)))){
                    return true;
                }
            }
        }
        if(startIndex == s.length() && (index == p.length() || allIsStar(p.substring(index)))){
            return true;
        }
        return false;
    }

    public static boolean allIsStar(String str){
        char[] charArray = str.toCharArray();
        for (char item : charArray) {
            if (item != '*') {
                return false;
            }
        }
        return true;
    }

    public static Node getMatch(String s ,String p,int selfIndex, int startIndex, int minLength){
        if(selfIndex >= p.length()){
            return null;
        }
        String matchStr = p.substring(selfIndex,selfIndex+1);
        if(startIndex + minLength > s.length()){
            return null;
        }
        String str = s.substring(startIndex,startIndex+minLength);
        if("*".equals(matchStr)){
            Node node = new Node();
            node.setSelfIndex(selfIndex);
            node.setStartIndex(startIndex);
            node.setMinLength(minLength);
            return node;
        }else if("?".equals(matchStr)){
            if(minLength != 1){
                return null;
            }
            Node node = new Node();
            node.setStartIndex(startIndex);
            node.setMinLength(minLength);
            node.setSelfIndex(selfIndex);
            return node;
        }else{
            if(minLength != 1 ||!matchStr.equals(str)){
                return null;
            }
            Node node = new Node();
            node.setStartIndex(startIndex);
            node.setMinLength(minLength);
            node.setSelfIndex(selfIndex);
            return node;
        }
    }
}