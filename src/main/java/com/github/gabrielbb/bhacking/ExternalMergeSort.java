package com.github.gabrielbb.bhacking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

public class ExternalMergeSort {

    public static void sort(File input, String outputFolder, int chunkSize) throws IOException {

        final var chunkFolder = new File(outputFolder, "chunks");
        chunkFolder.mkdirs();

        if (createChunks(input, chunkFolder, chunkSize)) {
            File result = mergeChunks(getChunks(chunkFolder), chunkSize);

            File finalResult = new File(outputFolder, "result.txt");
            finalResult.delete();

            result.renameTo(finalResult);

            getChunks(chunkFolder).forEach(File::delete);
        }
    }

    private static List<File> getChunks(File chunkFolder) throws IOException {
        return Files.walk(chunkFolder.toPath()).filter(Files::isRegularFile).map(Path::toFile)
                .collect(Collectors.toList());
    }

    private static File mergeChunks(List<File> chunks, int chunkSize) throws IOException {

        if (chunks.size() == 1)
            return chunks.get(0);

        File file1 = mergeChunks(chunks.subList(0, chunks.size() / 2), chunkSize);
        File file2 = mergeChunks(chunks.subList(chunks.size() / 2, chunks.size()), chunkSize);

        File outputFile = new File(file1.getParent(), UUID.randomUUID() + ".txt");

        try (var r1 = new BufferedReader(new FileReader(file1));
                var r2 = new BufferedReader(new FileReader(file2));
                var w = new BufferedWriter(new FileWriter(outputFile))) {

            var p = new PriorityQueue<Integer>();
            String r1Line, r2Line;

            while (true) {
                int chunkLines = 0;
                while (chunkLines <= chunkSize
                        && ((r1Line = r1.readLine()) != null | (r2Line = r2.readLine()) != null)) {

                    if (r1Line != null) {
                        p.add(Integer.parseInt(r1Line));
                        chunkLines++;
                    }

                    if (r2Line != null) {
                        p.add(Integer.parseInt(r2Line));
                        chunkLines++;
                    }
                }

                if (p.isEmpty())
                    break;

                while (!p.isEmpty()) {
                    w.append(p.poll().toString());
                    w.newLine();
                }

                w.flush();
            }

        }

        return outputFile;

    }

    private static boolean createChunks(File input, File chunkFolder, int chunkSize) throws IOException {
        int chunkCount = 0;

        try (Scanner s = new Scanner(input)) {

            final var nums = new ArrayList<Integer>();

            while (s.hasNextLine()) {
                chunkCount++;

                for (int i = 1; i <= chunkSize && s.hasNextLine(); i++)
                    nums.add(Integer.parseInt(s.nextLine()));

                Collections.sort(nums);

                Files.write(new File(chunkFolder, chunkCount + ".txt").toPath(),
                        nums.stream().map(n -> String.valueOf(n)).collect(Collectors.toList()));
                nums.clear();
            }
        }

        return chunkCount > 0;
    }
}