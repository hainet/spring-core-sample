package com.hainet.spring.core.sample;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;
import org.springframework.util.Assert;

public class AssertTest {

    @Test(expected = IllegalStateException.class)
    public void stateTest() {
        Assert.state(true, "State test");
        Assert.state(false, "State test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isTrueTest() {
        Assert.isTrue(true, "Is true test");
        Assert.isTrue(false, "Is true test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isNullTest() {
        Assert.isNull(null, "Is null test");
        Assert.isNull(new String(), "Is null test");
    }
}
