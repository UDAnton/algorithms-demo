package com.github.udanton.algorithms.demo.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public final class DatasetProvider {

    public static List<Integer> ascDataset(int size) {
        return IntStream.rangeClosed(1, size)
            .boxed()
            .collect(toList());
    }

    public static List<Integer> descDataset(int size) {
        return IntStream.rangeClosed(1, size)
            .map(value -> -value)
            .sorted()
            .map(value -> -value)
            .boxed()
            .collect(toList());
    }

    public static Set<Integer> rmdWithoutCopyDataset(int size, int from, int to) {
        Set<Integer> dataset = new LinkedHashSet<>();
        final Random random = new Random();
        while (size != dataset.size()) {
            dataset.add(random.nextInt(1 + to - from) + from);
        }
        return dataset;
    }

    public static List<Integer> rmdWithCopyDataset(int size, int from, int to) {
        List<Integer> dataset = new ArrayList<>();
        final Random random = new Random();
        for (int i = 0; i < size; i++) {
            dataset.add(random.nextInt(to - from) + from);
        }
        return dataset;
    }

    public static List<Integer> mountainDataset(int size) {
        List<Integer> list1 = IntStream.range(1, size / 2)
            .boxed()
            .collect(toList());
        List<Integer> list2 = IntStream.rangeClosed(size / 2, size)
            .map(value -> -value)
            .sorted()
            .map(value -> -value)
            .boxed()
            .collect(toList());
        List<Integer> dataset = new ArrayList<>();
        dataset.addAll(list1);
        dataset.addAll(list2);
        return dataset;
    }

    public static List<Integer> mutateDataset(Collection<Integer> dataset) {
        final Random random = new Random();
        return dataset.stream()
            .map(value -> {
                if (value % 2 == 0) {
                    return random.nextInt(100000 - 1) + 1;
                }
                return value;
            }).collect(toList());
    }

}
