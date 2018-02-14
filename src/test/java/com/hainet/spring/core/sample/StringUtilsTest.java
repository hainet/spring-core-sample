package com.hainet.spring.core.sample;

import org.junit.Test;
import org.springframework.util.StringUtils;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringUtilsTest {

    @Test
    public void isEmptyTest() {
        // OK
        assertThat(StringUtils.isEmpty(null), is(true));
        assertThat(StringUtils.isEmpty(""), is(true));

        // NG
        assertThat(StringUtils.isEmpty("It is not empty."), is(false));
    }
}
