package com.hainet.spring.core.sample;

import org.junit.Test;
import org.springframework.util.Assert;

import java.util.Arrays;

public class AssertTest {

    @Test(expected = IllegalStateException.class)
    public void stateTest() {
        // OK
        Assert.state(true, "Valid state.");

        // NG
        Assert.state(false, "Invalid state.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isTrueTest() {
        // OK
        Assert.isTrue(true, "Is true.");

        // NG
        Assert.isTrue(false, "Is false.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isNullTest() {
        // OK
        Assert.isNull(null, "Is null.");

        // NG
        Assert.isNull(new String(), "Is not null.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void notNullTest() {
        // OK
        Assert.notNull(new String(), "Is not null.");

        // NG
        Assert.notNull(null, "Is null.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void hasLengthTest() {
        // OK
        Assert.hasLength("Has length", "Text has length.");

        // NG
        Assert.hasLength("", "Text is empty.");
        Assert.hasLength(null, "Text is null.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void hasTextTest() {
        // OK
        Assert.hasText("Has length", "It has text.");

        // NG
        Assert.hasText("", "Text is empty.");
        Assert.hasText(null, "Text is null.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void doesNotContainTest() {
        // OK
        Assert.doesNotContain("Text to search", "It does not contain", "It does not contain.");

        // NG
        Assert.doesNotContain("Text to search", "Text to search", "It contains.");
        Assert.doesNotContain("", "Does not contain", "Text to search is empty.");
        Assert.doesNotContain(null, "Does not contain", "Text to search is null.");
        Assert.doesNotContain("Does not contain", "", "Substring is empty.");
        Assert.doesNotContain("Does not contain", null, "Substring is null.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void notEmptyTest() {
        // OK
        Assert.notEmpty(Arrays.asList("Not empty"), "It is not empty.");

        // NG
        Assert.notEmpty(Arrays.asList(), "It is empty.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void noNullElementsTest() {
        // OK
        Assert.noNullElements(new String[]{"", ""}, "No null elements.");

        // NG
        Assert.noNullElements(new String[]{"", null}, "Null elements.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void notEmptyCollectionTest() {
        // OK
        Assert.notEmpty(Arrays.asList(""), "It is not empty.");
        Assert.notEmpty(Arrays.asList("", null), "Null is also ok.");

        // NG
        Assert.notEmpty(Arrays.asList(), "It is empty.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isInstanceOfTest() {
        // OK
        Assert.isInstanceOf(String.class, "value", "It is String value.");

        // NG
        Assert.isInstanceOf(String.class, 1, "It is int value.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isAssignableTest() {
        // OK
        Assert.isAssignable(Exception.class, IllegalArgumentException.class, "It is assignable.");

        // NG
        Assert.isAssignable(Error.class, IllegalArgumentException.class, "It is not assignable.");
    }
}
