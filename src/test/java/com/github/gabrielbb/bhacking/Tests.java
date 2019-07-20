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
        String result = LongestCommonSubstring.getLongestCommonSubstring("hola-casa_loca", "adios_casa_fea");
        Assert.assertEquals("casa_", result);

        result = LongestCommonSubstring.getLongestCommonSubstring("ABABC", "BABCA");
        Assert.assertEquals("BABC", result);
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
