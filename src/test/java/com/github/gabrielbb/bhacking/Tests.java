package com.github.gabrielbb.bhacking;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Tests {

    @Test
    public void testLongestCommonSubstring() {
        String result = LongestCommonSubstring.getLongestCommonSubstringNaive("hola-casa_loca", "adios_casa_fea");
        Assert.assertEquals("casa_", result);

        result = LongestCommonSubstring.getLongestCommonSubstringNaive("ABABC", "BABCA");
        Assert.assertEquals("BABC", result);
    }

    @Test
    public void testLongestPalindromicSubsequence() {
        String testCase = "ABBDCACB";
        Assert.assertEquals(5, LongestPalindromicSubsequence.getLength(testCase, 0, testCase.length() - 1));

        testCase = "PERTO";
        Assert.assertEquals(1, LongestPalindromicSubsequence.getLength(testCase, 0, testCase.length() - 1));

        testCase = "ABBDCACB";
        Assert.assertEquals("BCACB", LongestPalindromicSubsequence.getString(testCase, 0, testCase.length() - 1));

        /*testCase = "CARLON";
        Assert.assertEquals("", LongestPalindromicSubsequence.getString(testCase, 0, testCase.length() - 1));*/
    }

    @Test
    public void testLongestCommonSubstringLength() {
        Assert.assertEquals(6,
                LongestCommonSubstring.getLongestCommonSubstringLength("hola_casa_loca", "adios_casa_fea"));
        Assert.assertEquals(4, LongestCommonSubstring.getLongestCommonSubstringLength("ABABC", "BABCA"));
        Assert.assertEquals(1, LongestCommonSubstring.getLongestCommonSubstringLength("A", "A"));
    }

    @Test
    public void testLongestCommonSubsequenceLength() {
        /*
        	p c r e a s o o a
        c	0 1 1 1 1 1 1 1 1
        a	0 1 1 1 2 2 2 2 1
        s	0 1 1 1 1 3 3 3 3
        a	0 1 1 1 2 2 2 2 4
        z
        */
        Assert.assertEquals(4, LongestCommonSubsequence.getLength("pcreasooa", "casa"));
    }

    @Test
    public void testExternalMergeSort() throws IOException {
        File testFile = new File(getClass().getClassLoader().getResource("external_merge_sort.txt").getFile());

        assertTrue(testFile.exists());

        List<Integer> testData = Files.readAllLines(testFile.toPath()).stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        assertFalse(testData.isEmpty());

        Collections.sort(testData);

        ExternalMergeSort.sort(testFile, testFile.getParent(), 20);

        File resultFile = new File(getClass().getClassLoader().getResource("result.txt").getFile());

        assertTrue(resultFile.exists());

        List<Integer> resultData = Files.readAllLines(resultFile.toPath()).stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        assertFalse(resultData.isEmpty());

        assertTrue(testData.equals(resultData));
    }
}
