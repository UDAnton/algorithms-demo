package com.github.udanton.algorithms.demo.sort;

import com.github.udanton.algorithms.demo.util.DatasetProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CountingSortExecutor {

    public void execute(int size, int range) {
        int[] array = DatasetProvider.rmdWithCopyDataset(size, 1, range)
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();
        long before = System.currentTimeMillis();
        int[] sorted = sort(array);
        long now = System.currentTimeMillis();
        log.info("Counting Sort [dataset size: {}, range: {}] takes {} seconds.", size, range, (now-before)/1000F);
    }


    private static int[] sort(int[] array) {

        if (array == null || array.length <= 1)
            return null;

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }

        int[] count = new int[max + 1];

        for (int j : array) {
            count[j]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] temp = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            int element = array[i];
            int position = count[element] - 1;
            temp[position] = element;
            count[element]--;
        }

        return temp;
    }

}
