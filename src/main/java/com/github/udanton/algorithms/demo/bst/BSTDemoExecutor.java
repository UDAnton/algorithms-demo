package com.github.udanton.algorithms.demo.bst;

import java.util.Collection;
import java.util.List;

import com.github.udanton.algorithms.demo.util.DatasetProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BSTDemoExecutor {

    public void execute(int size) {
        testBinarySearchWithAscDataset(size);
        testBinarySearchWithDescDataset(size);
        testBinarySearchWithRmdWithCopy(size);
        testBinarySearchWithRmdWithoutCopy(size);
        testBinarySearchWithMountainDataset(size);
        testBinarySearchWithMutatedDataset(size);
    }

    private void testBinarySearchWithAscDataset(int size) {
        final Collection<Integer> ascDataset = DatasetProvider.ascDataset(size);
        final BinarySearchTree binarySearchTree = new BinarySearchTree();

        // insert
        long before = System.currentTimeMillis();
        for (int value : ascDataset) {
            binarySearchTree.add(value);
        }
        long now = System.currentTimeMillis();
        log.info("BTS insert operation [dataset size: {}, datasetType: {}] takes {} seconds.", size, "asc", (now-before)/1000F);

        // find
        before = System.currentTimeMillis();
        for (int value : ascDataset) {
            log.info("Result: {}",binarySearchTree.contains(value));
        }
        now = System.currentTimeMillis();
        log.info("BTS find operation [dataset size: {}, datasetType: {}] takes {} seconds.", size, "asc", (now-before)/1000F);

        // delete
        before = System.currentTimeMillis();
        for (int value : ascDataset) {
            binarySearchTree.delete(value);
        }
        now = System.currentTimeMillis();
        log.info("BTS delete operation [dataset size: {}, datasetType: {}] takes {} seconds.", size, "asc", (now-before)/1000F);
    }

    private void testBinarySearchWithDescDataset(int size) {
        final Collection<Integer> descDataset = DatasetProvider.descDataset(size);
        final BinarySearchTree binarySearchTree = new BinarySearchTree();

        // insert
        long before = System.currentTimeMillis();
        for (int value : descDataset) {
            binarySearchTree.add(value);
        }
        long now = System.currentTimeMillis();
        log.info("BTS insert operation [dataset size: {}, datasetType: {}] takes {} seconds.", size, "desc", (now-before)/1000F);

        // find
        before = System.currentTimeMillis();
        for (int value : descDataset) {
            log.info("Result: {}",binarySearchTree.contains(value));
        }
        now = System.currentTimeMillis();
        log.info("BTS find operation [dataset size: {}, datasetType: {}] takes {} seconds.", size, "desc", (now-before)/1000F);

        // delete
        before = System.currentTimeMillis();
        for (int value : descDataset) {
            binarySearchTree.delete(value);
        }
        now = System.currentTimeMillis();
        log.info("BTS delete operation [dataset size: {}, datasetType: {}] takes {} seconds.", size, "desc", (now-before)/1000F);
    }

    private void testBinarySearchWithRmdWithoutCopy(int size) {
        final Collection<Integer> rmdWithoutCopyDataset = DatasetProvider.rmdWithoutCopyDataset(size, 1, size);
        final BinarySearchTree binarySearchTree = new BinarySearchTree();

        // insert
        long before = System.currentTimeMillis();
        for (int value : rmdWithoutCopyDataset) {
            binarySearchTree.add(value);
        }
        long now = System.currentTimeMillis();
        log.info("BTS insert operation [dataset size: {}, datasetType: {}] takes {} seconds.", size, "rmd-without-copies", (now-before)/1000F);

        // find
        before = System.currentTimeMillis();
        for (int value : rmdWithoutCopyDataset) {
            log.info("Result: {}",binarySearchTree.contains(value));
        }
        now = System.currentTimeMillis();
        log.info("BTS find operation [dataset size: {}, datasetType: {}] takes {} seconds.", size, "rmd-without-copies", (now-before)/1000F);

        // delete
        before = System.currentTimeMillis();
        for (int value : rmdWithoutCopyDataset) {
            binarySearchTree.delete(value);
        }
        now = System.currentTimeMillis();
        log.info("BTS delete operation [dataset size: {}, datasetType: {}] takes {} seconds.", size, "rmd-without-copies", (now-before)/1000F);
    }

    private void testBinarySearchWithRmdWithCopy(int size) {
        final Collection<Integer> rmdWithCopyDataset = DatasetProvider.rmdWithCopyDataset(size, 1, size);
        final BinarySearchTree binarySearchTree = new BinarySearchTree();

        // insert
        long before = System.currentTimeMillis();
        for (int value : rmdWithCopyDataset) {
            binarySearchTree.add(value);
        }
        long now = System.currentTimeMillis();
        log.info("BTS insert operation [dataset size: {}, datasetType: {}] takes {} seconds.", size, "rmd-with-copies", (now-before)/1000F);

        // find
        before = System.currentTimeMillis();
        for (int value : rmdWithCopyDataset) {
            log.info("Result: {}",binarySearchTree.contains(value));
        }
        now = System.currentTimeMillis();
        log.info("BTS find operation [dataset size: {}, datasetType: {}] takes {} seconds.", size, "rmd-with-copies", (now-before)/1000F);

        // delete
        before = System.currentTimeMillis();
        for (int value : rmdWithCopyDataset) {
            binarySearchTree.delete(value);
        }
        now = System.currentTimeMillis();
        log.info("BTS delete operation [dataset size: {}, datasetType: {}] takes {} seconds.", size, "rmd-with-copies", (now-before)/1000F);
    }

    private void testBinarySearchWithMountainDataset(int size) {
        final Collection<Integer> mountainDataset = DatasetProvider.mountainDataset(size);
        final BinarySearchTree binarySearchTree = new BinarySearchTree();

        // insert
        long before = System.currentTimeMillis();
        for (int value : mountainDataset) {
            binarySearchTree.add(value);
        }
        long now = System.currentTimeMillis();
        log.info("BTS insert operation [dataset size: {}, datasetType: {}] takes {} seconds.", size, "mountain", (now-before)/1000F);

        // find
        before = System.currentTimeMillis();
        for (int value : mountainDataset) {
            log.info("Result: {}",binarySearchTree.contains(value));
        }
        now = System.currentTimeMillis();
        log.info("BTS find operation [dataset size: {}, datasetType: {}] takes {} seconds.", size, "mountain", (now-before)/1000F);

        // delete
        before = System.currentTimeMillis();
        for (int value : mountainDataset) {
            binarySearchTree.delete(value);
        }
        now = System.currentTimeMillis();
        log.info("BTS delete operation [dataset size: {}, datasetType: {}] takes {} seconds.", size, "mountain", (now-before)/1000F);
    }

    private void testBinarySearchWithMutatedDataset(int size) {
        final Collection<Integer> rmdWithoutCopyDataset = DatasetProvider.rmdWithoutCopyDataset(size, 1, size);
        final BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int value : rmdWithoutCopyDataset) {
            binarySearchTree.add(value);
        }
        // find
        List<Integer> mutateDataset = DatasetProvider.mutateDataset(rmdWithoutCopyDataset);
        long before = System.currentTimeMillis();
        for (int value : mutateDataset) {
            log.info("Result: {}",binarySearchTree.contains(value));
        }
        long now = System.currentTimeMillis();
        log.info("BTS find operation [dataset size: {}, datasetType: {}] takes {} seconds.", size, "mutated", (now-before)/1000F);
    }

}
