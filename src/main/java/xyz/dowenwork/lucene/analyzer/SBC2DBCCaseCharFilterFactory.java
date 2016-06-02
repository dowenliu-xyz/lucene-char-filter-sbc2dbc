package xyz.dowenwork.lucene.analyzer;

import org.apache.lucene.analysis.util.CharFilterFactory;

import java.io.Reader;
import java.util.Map;

/**
 * <p>create at 16-6-2</p>
 *
 * @author liufl
 * @since 5.5.0.0
 */
@SuppressWarnings("unused")
public class SBC2DBCCaseCharFilterFactory extends CharFilterFactory {
    /**
     * Initialize this factory via a set of key-value pairs.
     */
    public SBC2DBCCaseCharFilterFactory(Map<String, String> args) {
        super(args);
    }

    @Override
    public Reader create(Reader input) {
        return new SBC2DBCCaseCharFilter(input);
    }
}
