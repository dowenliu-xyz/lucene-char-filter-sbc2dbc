package xyz.dowenwork.lucene.analyzer;

import org.apache.lucene.analysis.charfilter.BaseCharFilter;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * 全角转半角charFilter
 * <p>create at 16-6-2</p>
 *
 * @author liufl
 * @since 5.5.0.0
 */
public class SBC2DBCCaseCharFilter extends BaseCharFilter {
    private Reader transformedInput;

    public SBC2DBCCaseCharFilter(Reader in) {
        super(in);
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        // Buffer all input on the first call.
        if (transformedInput == null) {
            fill();
        }
        return transformedInput.read(cbuf, off, len);
    }

    private void fill() throws IOException {
        StringBuilder buffered = new StringBuilder();
        char[] temp = new char[1024];
        for (int cnt = input.read(temp); cnt > 0; cnt = input.read(temp)) {
            buffered.append(temp, 0, cnt);
        }
        transformedInput = new StringReader(
                SBC2DBCCaseTransformer.transform(buffered.toString()));
    }

    @Override
    public int read() throws IOException {
        if (transformedInput == null) {
            fill();
        }
        return transformedInput.read();
    }

    @Override
    protected int correct(int currentOff) {
        return Math.max(0, super.correct(currentOff));
    }
}
