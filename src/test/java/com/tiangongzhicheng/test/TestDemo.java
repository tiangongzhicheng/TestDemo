package com.tiangongzhicheng.test;


import com.tiangongzhicheng.learndemo.service.translate.TransApi;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestDemo {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20191010000340415";
    private static final String SECURITY_KEY = "1uaHrmt1htBbh3QY6kKe";

    public static void main(String[] args) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String query = "生成文件失败";
        System.out.println(api.getTransResult(query, "auto", "en"));
    }

    @Test
    public void test() {
        String dataStr = "\\u4f60\\u8fd8\\u597d\\u5417\\uff1f";
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        System.out.println(buffer.toString());

    }

    @Test
    public void test2() {
        CopyOnWriteArrayList<Object> objects = new CopyOnWriteArrayList<>();
        objects.add(12);
    }
}

