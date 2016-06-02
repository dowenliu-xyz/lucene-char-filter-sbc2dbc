package xyz.dowenwork.lucene.analyzer;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.*;

public class SBC2DBCCaseCharFilterTest {
    @Test
    public void test() throws IOException {
        String origin = "hello!！ 全角转换，ＤＡＯ ５３２３２　";
        SBC2DBCCaseCharFilter charFilter = new SBC2DBCCaseCharFilter(new StringReader(origin));
        int nc;
        StringBuilder builder = new StringBuilder();
        while ((nc = charFilter.read()) != -1) {
            builder.append((char) nc);
        }
        assertEquals("hello!! 全角转换,DAO 53232 ", builder.toString());
    }
}