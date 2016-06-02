package xyz.dowenwork.lucene.analyzer;

import java.io.UnsupportedEncodingException;

/**
 * 全角转半角转换器
 * <p>create at 16-6-2</p>
 *
 * @author liufl
 * @since 5.5.0.0
 */
public class SBC2DBCCaseTransformer {
    public static String transform(String sbcStr)
            throws UnsupportedEncodingException {
        StringBuilder builder = new StringBuilder("");
        String charStr;
        byte[] b;
        for (int i = 0; i < sbcStr.length(); i++) {
            charStr = sbcStr.substring(i, i + 1);
            // 全角空格转换成半角空格
            if (charStr.equals("　")) {
                builder.append(" ");
                continue;
            }
            b = charStr.getBytes("unicode");
            // 得到 unicode 字节数据
            if (b[2] == -1) {
                b[3] = (byte) (b[3] + 32);
                b[2] = 0;
                builder.append(new String(b, "unicode"));
            } else {
                builder.append(charStr);
            }
        }
        return builder.toString();
    }
}
