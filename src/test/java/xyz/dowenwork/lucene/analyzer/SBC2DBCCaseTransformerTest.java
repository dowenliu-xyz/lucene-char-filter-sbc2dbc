package xyz.dowenwork.lucene.analyzer;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

public class SBC2DBCCaseTransformerTest {
    @Test
    public void testTransform() throws UnsupportedEncodingException {
        String origin = "hello!！ 全角转换，ＤＡＯ ５３２３２　";
        String dbc = SBC2DBCCaseTransformer.transform(origin);
        assertEquals("hello!! 全角转换,DAO 53232 ", dbc);
    }
}