package com.jzoffer;


import javax.swing.text.StyledEditorKit;

/**
 * @author liqing
 * @version 1.0
 * @date 2020-03-13 20:36
 * @description 字符串匹配，模式字符串中，"." 可以代表任意字符，"*" 代表它前面的字符出现的次数(可以是 0 次)
 */
public class RegularExpression_19 {
    public static boolean isMatch(String s, String p){

        return match(s,p,0,0);

    }

    public static boolean match(String s, String p, int index1, int index2){

        // 终止条件1 当字符串 s 遍历完成 并且 如果模式串 p 也遍历完，或者 模式串 p 的最后一个字符为 *
        if (index1 == s.length() && (index2 == p.length() || index2 + 1 == p.length()-1 && p.charAt(index2 + 1) == "*".charAt(0))){
            return  true;
        }
        // 终止条件2 当字符串 s 遍历完成 或者 模式串 p 遍历完成
        if (index1 == s.length() || index2 == p.length()){

            if (index1 == s.length()){
                if (change(p,index2)){
                    return  true;
                }
                else {
                    return false;
                }

            }
            // 如果模式串 p 遍历完成，字符串 s 未遍历完成，则直接返回 false
            else {
                return  false;
            }
        }

        // 如果模式串 p 的下一个字符为"*"
        if (index2 + 1 < p.length() && p.charAt(index2 + 1) == "*".charAt(0)){
            // 如果当前 s 和 p 的字符相等
            if (judge(s.charAt(index1),p.charAt(index2))){
                // 字符串 s 指向下一个字符，模式串 p 不动，或者 字符串 s 指向下一个字符，模式串 P 指向下下个字符
                return match(s,p,index1+1,index2) || match(s,p,index1+1,index2 + 2);
            }else {
                return match(s,p,index1,index2 + 2);
            }
        }

        // 如果字符串 s 和模式串 p 当前指向的字符相等，则 s 指向下一个字符， p 指向下一个字符
        if (s.charAt(index1) == p.charAt(index2)){

            return match(s,p,index1 + 1,index2 + 1);
        }
        // 如果字符串 s 和模式串 p 当前指向的字符不想等
        return  false;

    }

    public static boolean judge(char c1, char c2){

        // 如果两个字符相等，或者模式字符串里的字符为"."，则返回 true
        if (c1 == c2 || c2 == ".".charAt(0) ){
            return  true;
        }

        return false;
    }

    public static boolean change(String str, int index){
//        while (index  < str.length()){
//
//            // 如果模式串 p 中下下个字符不为 *,则返回 false
//            if ( index + 1 < str.length() && str.charAt(index + 1) != "*".charAt(0))
//                return  false;
//            index += 2;
//        }
//
//        return true;

        while (index < str.length()) {
            if (index + 1 < str.length() && str.charAt(index + 1) == '*') {
                index += 2;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "aaa";
        String b = "aaaa*";
        System.out.println(isMatch(a,b));
    }
}
