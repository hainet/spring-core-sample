package com.hainet.spring.core.sample;

import org.junit.Test;
import org.springframework.util.StringUtils;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringUtilsTest {

    @Test
    public void isEmptyTest() {
        // True
        assertThat(StringUtils.isEmpty(""), is(true));
        assertThat(StringUtils.isEmpty(null), is(true));

        // False
        assertThat(StringUtils.isEmpty("It is not empty."), is(false));
    }

    @Test
    public void hasLengthTest() {
        // True
        assertThat(StringUtils.hasLength("It has length."), is(true));
        assertThat(StringUtils.hasLength(" "), is(true));

        // False
        assertThat(StringUtils.hasLength(""), is(false));
        assertThat(StringUtils.hasLength(null), is(false));
    }

    @Test
    public void hasTextTest() {
        // True
        assertThat(StringUtils.hasText("It has text"), is(true));

        // False
        assertThat(StringUtils.hasText(""), is(false));
        assertThat(StringUtils.hasText(" "), is(false));
        assertThat(StringUtils.hasText(null), is(false));
    }

    @Test
    public void containsWhitespaceTest() {
        // True
        assertThat(StringUtils.containsWhitespace(" "), is(true));

        // False
        assertThat(StringUtils.containsWhitespace(""), is(false));
        assertThat(StringUtils.containsWhitespace(null), is(false));
    }

    @Test
    public void trimWhiteSpaceTest() {
        assertThat(StringUtils.trimWhitespace(""), is(""));
        assertThat(StringUtils.trimWhitespace(" "), is(""));
        assertThat(StringUtils.trimWhitespace(" start"), is("start"));
        assertThat(StringUtils.trimWhitespace("end "), is("end"));
        assertThat(StringUtils.trimWhitespace(" both "), is("both"));
        assertThat(StringUtils.trimWhitespace("foo bar"), is("foo bar"));
    }

    @Test
    public void trimAllWhiteSpaceTest() {
        assertThat(StringUtils.trimAllWhitespace(""), is(""));
        assertThat(StringUtils.trimAllWhitespace(" "), is(""));
        assertThat(StringUtils.trimAllWhitespace(" start"), is("start"));
        assertThat(StringUtils.trimAllWhitespace("end "), is("end"));
        assertThat(StringUtils.trimAllWhitespace(" both "), is("both"));
        assertThat(StringUtils.trimAllWhitespace("foo bar"), is("foobjar"));
    }
}
