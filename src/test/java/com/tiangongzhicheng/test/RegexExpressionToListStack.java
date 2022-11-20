package com.tiangongzhicheng.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RegexExpressionToListStack {


    @Test
    public void test2() throws Exception {
        String param = "收益率[0-100]%|收益[0-100]%|回报[0-100]%|稳定|安全";
        List<String> strings = regexExpressionToList(param);
        System.out.println(strings);

    }

    /**
     * 正则表达式转List
     * @param param
     * @return
     * @throws Exception
     */
    public List<String> regexExpressionToList(String param) throws Exception {

        String splitStr = "QWERT";
        if(StringUtils.isBlank(param)){
            return new ArrayList<String>();
        }
        if(!StringUtils.contains(param,"(") && !StringUtils.contains(param,"[")){
            String[] split = param.split("\\|");
            return Arrays.asList(split);
        }
        StringBuilder result = new StringBuilder();
        int beginIndex = 0;
        int previousAppendIndex = -1;
        Stack<Character> charStack = new Stack<Character>();
        Stack<Integer> indexStack = new Stack<Integer>();
        boolean canAppend = false;
        for (int i = 0; i < param.length(); i++) {
            char str = param.charAt(i);
            if((peek(charStack) == '[' && str == ']') || (peek(charStack) == '(' && str == ')')){
                if(charStack.size() == 1){
                    beginIndex = indexStack.peek();
                }
                charStack.pop();
                indexStack.pop();
            }else if(str == '(' || str == '['){
                //如果放入前栈为空，拼接上个‘)’至此的字符
                if(i>0 && charStack.empty()){
                    result.append(param.substring(previousAppendIndex+1,i).replaceAll("\\|",splitStr));
                }
                charStack.push(str);
                indexStack.push(i);
                canAppend = true;
            }
            if(canAppend && charStack.empty()){
                result.append(param.substring(beginIndex,i+1));
                previousAppendIndex = i;
                canAppend = false;
            }
        }
        result.append(param.substring(previousAppendIndex+1).replaceAll("\\|",splitStr));
        String string = result.toString();
        String[] resultArray = string.split(splitStr);
        return Arrays.asList(resultArray);
    }

    private char peek(Stack<Character> charStack) {
        if(charStack.empty()){
            return ' ';
        }
        return charStack.peek();
    }
}
