package com.github.gabrielbb.algorithms;

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
    public void testFindSubstring() {
        Assert.assertEquals(-1, FindSubstring.findSubstring("practice", "geeksforgeeks"));
        Assert.assertEquals(5, FindSubstring.findSubstring("for", "geeksforgeeks"));
    }

    @Test
    public void testLongestPalindromicSubsequence() {
        String testCase = "ABBDCACB";
        Assert.assertEquals(5, LongestPalindromicSubsequence.getLength(testCase, 0, testCase.length() - 1));

        testCase = "PERTO";
        Assert.assertEquals(1, LongestPalindromicSubsequence.getLength(testCase, 0, testCase.length() - 1));

        testCase = "ABBDCACB";
        Assert.assertEquals("BCACB", LongestPalindromicSubsequence.getString(testCase, 0, testCase.length() - 1));

        /*
         * testCase = "CARLON"; Assert.assertEquals("",
         * LongestPalindromicSubsequence.getString(testCase, 0, testCase.length() - 1));
         */
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
        Assert.assertEquals(4, LongestCommonSubsequence.getLength("pcreasooa", "casa"));
    }

    @Test
    public void testLongestSubsetSum() {
        Assert.assertEquals(18, LongestSubsetSum.find(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3));
        Assert.assertEquals(15, LongestSubsetSum.find(new int[] { 5, 3, 7, 1, 5, 6, 2 }, 3));
    }

    @Test
    public void testUniqueWords() {
        Assert.assertArrayEquals(new String[] { "Java", "Grails", "also" },
                UniqueWords.getUniqueWords("Java is great. Grails is also great"));
    }

    @Test
    public void testDigitSwapping() {
        Assert.assertEquals(8530, DigitSwapping.swap(3580));
    }

    @Test
    public void testAnagramSubstring() {
        Assert.assertEquals(1, AnagramSubstring.get("ping", "jingp"));
        Assert.assertEquals(-1, AnagramSubstring.get("ping", "ijngp"));
    }

    @Test
    public void mergeTwoSortedArrays() {
        Assert.assertArrayEquals(new int[] { 1, 2, 2, 3, 4, 6, 7, 9 },
                MergeTwoArrays.merge(new int[] { 1, 3, 6, 7 }, new int[] { 2, 2, 4, 9 }));

        Assert.assertArrayEquals(new int[] { 1, 2, 3, 5, 6, 7 },
                MergeTwoArrays.merge(new int[] { 1, 3, 6, 7 }, new int[] { 2, 5 }));
    }

    @Test
    public void testNthFibonacciNumber() {
        Assert.assertEquals(5, NthFibonacci.get(5));
        Assert.assertEquals(55, NthFibonacci.get(10));
        Assert.assertEquals(23416728348467685L, NthFibonacci.get(80));
    }

    //@Test
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
