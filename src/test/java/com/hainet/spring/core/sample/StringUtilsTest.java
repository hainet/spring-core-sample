package com.hainet.spring.core.sample;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
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
        assertThat(StringUtils.trimWhitespace(null), is(nullValue()));
    }

    @Test
    public void trimAllWhiteSpaceTest() {
        assertThat(StringUtils.trimAllWhitespace(""), is(""));
        assertThat(StringUtils.trimAllWhitespace(" "), is(""));
        assertThat(StringUtils.trimAllWhitespace(" start"), is("start"));
        assertThat(StringUtils.trimAllWhitespace("end "), is("end"));
        assertThat(StringUtils.trimAllWhitespace(" both "), is("both"));
        assertThat(StringUtils.trimAllWhitespace("foo bar"), is("foobar"));
        assertThat(StringUtils.trimAllWhitespace(null), is(nullValue()));
    }

    @Test
    public void trimLeadingWhitespaceTest() {
        assertThat(StringUtils.trimLeadingWhitespace(""), is(""));
        assertThat(StringUtils.trimLeadingWhitespace(" "), is(""));
        assertThat(StringUtils.trimLeadingWhitespace(" start"), is("start"));
        assertThat(StringUtils.trimLeadingWhitespace("end "), is("end "));
        assertThat(StringUtils.trimLeadingWhitespace(" both "), is("both "));
        assertThat(StringUtils.trimLeadingWhitespace("foo bar"), is("foo bar"));
        assertThat(StringUtils.trimLeadingWhitespace(null), is(nullValue()));
    }

    @Test
    public void trimTrailingWhitespaceTest() {
        assertThat(StringUtils.trimTrailingWhitespace(""), is(""));
        assertThat(StringUtils.trimTrailingWhitespace(" "), is(""));
        assertThat(StringUtils.trimTrailingWhitespace(" start"), is(" start"));
        assertThat(StringUtils.trimTrailingWhitespace("end "), is("end"));
        assertThat(StringUtils.trimTrailingWhitespace(" both "), is(" both"));
        assertThat(StringUtils.trimTrailingWhitespace("foo bar"), is("foo bar"));
        assertThat(StringUtils.trimTrailingWhitespace(null), is(nullValue()));
    }

    @Test
    public void startsWithIgnoreCaseTest() {
        // True
        assertThat(StringUtils.startsWithIgnoreCase("Starts with ignore case.", "starts"), is(true));
        assertThat(StringUtils.startsWithIgnoreCase("Starts with ignore case.", "STARTS"), is(true));
        assertThat(StringUtils.startsWithIgnoreCase("It contains white space.", "It "), is(true));

        // False
        assertThat(StringUtils.startsWithIgnoreCase("12345", "1234567890"), is(false));
        assertThat(StringUtils.startsWithIgnoreCase(null, "null"), is(false));
        assertThat(StringUtils.startsWithIgnoreCase("null", null), is(false));
        assertThat(StringUtils.startsWithIgnoreCase(null, null), is(false));
    }

    @Test
    public void endsWithIgnoreCaseTest() {
        // True
        assertThat(StringUtils.endsWithIgnoreCase("Ends with ignore case.", "case."), is(true));
        assertThat(StringUtils.endsWithIgnoreCase("Ends with ignore case.", "CASE."), is(true));
        assertThat(StringUtils.endsWithIgnoreCase("It contains white space.", " space."), is(true));

        // False
        assertThat(StringUtils.endsWithIgnoreCase("54321", "0987654321"), is(false));
        assertThat(StringUtils.endsWithIgnoreCase(null, "null"), is(false));
        assertThat(StringUtils.endsWithIgnoreCase("null", null), is(false));
        assertThat(StringUtils.endsWithIgnoreCase(null, null), is(false));
    }

    @Test(expected = NullPointerException.class)
    public void substringMatchTest() {
        // True
        assertThat(StringUtils.substringMatch("Original", 0, "Original"), is(true));
        assertThat(StringUtils.substringMatch("Original", 3, "ginal"), is(true));
        assertThat(StringUtils.substringMatch("Original", 0, ""), is(true));

        // False
        assertThat(StringUtils.substringMatch("Original", 0, "OriginalOriginal"), is(false));
        StringUtils.substringMatch(null, 0, null);
    }

    @Test
    public void countOccurrencesOfTest() {
        assertThat(StringUtils.countOccurrencesOf("122333", "1"), is(1));
        assertThat(StringUtils.countOccurrencesOf("122333", "2"), is(2));
        assertThat(StringUtils.countOccurrencesOf("122333", "3"), is(3));

        assertThat(StringUtils.countOccurrencesOf("", ""), is(0));
        assertThat(StringUtils.countOccurrencesOf(null, null), is(0));
    }

    @Test
    public void replaceTest() {
        assertThat(StringUtils.replace("122333", "2", "4"), is("144333"));

        assertThat(StringUtils.replace("122333", "", ""), is("122333"));
        assertThat(StringUtils.replace("122333", null, null), is("122333"));
    }

    @Test
    public void deleteTest() {
        assertThat(StringUtils.delete("122333", "2"), is("1333"));

        assertThat(StringUtils.delete("122333", ""), is("122333"));
        assertThat(StringUtils.delete("122333", null), is("122333"));
    }

    @Test
    public void deleteAnyTest() {
        assertThat(StringUtils.deleteAny("122333", "23"), is("1"));

        assertThat(StringUtils.deleteAny("122333", ""), is("122333"));
        assertThat(StringUtils.deleteAny("122333", null), is("122333"));
    }

    @Test
    public void quoteTest() {
        assertThat(StringUtils.quote("hainet"), is("'hainet'"));

        assertThat(StringUtils.quote(""), is("''"));
        assertThat(StringUtils.quote(null), is(nullValue()));
    }

    @Test
    public void quoteIfStringTest() {
        assertThat(StringUtils.quoteIfString("hainet"), is("'hainet'"));
        final Object object = new Object();
        assertThat(StringUtils.quoteIfString(object), is(object));

        assertThat(StringUtils.quoteIfString(""), is("''"));
        assertThat(StringUtils.quoteIfString(null), is(nullValue()));
    }

    @Test(expected = NullPointerException.class)
    public void unqualifyTest() {
        assertThat(StringUtils.unqualify("com.hainet"), is("hainet"));

        assertThat(StringUtils.unqualify(""), is(""));
        assertThat(StringUtils.unqualify(null), is(nullValue()));
    }

    @Test
    public void capitalizeTest() {
        assertThat(StringUtils.capitalize("hainet"), is("Hainet"));

        assertThat(StringUtils.capitalize(""), is(""));
        assertThat(StringUtils.capitalize(null), is(nullValue()));
    }

    @Test
    public void uncapitalizeTest() {
        assertThat(StringUtils.uncapitalize("HAINET"), is("hAINET"));

        assertThat(StringUtils.uncapitalize(""), is(""));
        assertThat(StringUtils.uncapitalize(null), is(nullValue()));
    }

    @Test
    public void getFilenameTest() {
        assertThat(StringUtils.getFilename("com/hainet.java"), is("hainet.java"));

        assertThat(StringUtils.getFilename(""), is(""));
        assertThat(StringUtils.getFilename(null), is(nullValue()));
    }

    @Test
    public void getFilenameExtensionTest() {
        assertThat(StringUtils.getFilenameExtension("com/hainet.java"), is("java"));

        assertThat(StringUtils.getFilenameExtension(""), is(nullValue()));
        assertThat(StringUtils.getFilenameExtension(null), is(nullValue()));
    }

    @Test
    public void stripFilenameExtensionTest() {
        assertThat(StringUtils.stripFilenameExtension("com/hainet.java"), is("com/hainet"));

        assertThat(StringUtils.stripFilenameExtension(""), is(""));
        assertThat(StringUtils.stripFilenameExtension(null), is(nullValue()));
    }

    @Test(expected = NullPointerException.class)
    public void applyRelativePathTest() {
        assertThat(StringUtils.applyRelativePath("com/", "hainet"), is("com/hainet"));
        assertThat(StringUtils.applyRelativePath("com/", "/hainet"), is("com/hainet"));

        assertThat(StringUtils.applyRelativePath("/com", "hainet"), is("/hainet"));

        assertThat(StringUtils.applyRelativePath("", "hainet"), is("hainet"));
        assertThat(StringUtils.applyRelativePath("com/", ""), is("com/"));

        StringUtils.applyRelativePath("com/", null);
        StringUtils.applyRelativePath(null, "hainet");
    }

    @Test
    public void sortStringArrayTest() {
        final String[] array = {"2", "1"};
        final String[] expected = {"1", "2"};
        assertThat(StringUtils.sortStringArray(array), is(expected));

        final String[] empty = {};
        assertThat(StringUtils.sortStringArray(null), is(empty));
    }

    @Test
    public void toStringArrayTest() {
        List<String> strings = new ArrayList<>();

        strings.clear();
        strings.add("hainet");
        String[] one = {"hainet"};
        assertThat(StringUtils.toStringArray(strings), is(one));

        strings.clear();
        String[] empty = {};
        assertThat(StringUtils.toStringArray(strings), is(empty));

        strings = null;
        assertThat(StringUtils.toStringArray(strings), is(nullValue()));
    }
}
