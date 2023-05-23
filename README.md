## Demo algorithms

The demo is written in Java and contains custom implementation of the Tree and Sorting algorithms.

The tree implementation is located in the [BinarySearchTree.java](src/main/java/com/github/udanton/algorithms/demo/bst/BinarySearchTree.java) file.

The sorting algorithm is located in the [CountingSortExecutor.java](src/main/java/com/github/udanton/algorithms/demo/sort/CountingSortExecutor.java) file.

The test datasets generator functions are located in the [DatasetProvider.java](src/main/java/com/github/udanton/algorithms/demo/util/DatasetProvider.java) file.

---

## How to build and run

Run with docker container:

```
docker start
```

---

## Datasets

1. Ascending dataset [1 ... size]
2. Descending dataset [size ... 1]
3. Random with copies dataset (random value from 1 to array size)
4. Random without copies dataset (random value from 1 to array size)
5. Mountain dataset [1 ... size/2 ... size]
5. Mutated dataset for search operation (random value from 1 to array size that was changed after inserting to BST)

---

## Binary Search Tree test conditionals 

1. Performance results for inserts operations:

   |Size     |Ascending|Descending|RND with copies|RND without copies|Mountain|
   |---------|---------|----------|---------------|------------------|--------|
   |100000   |0.024    |0.025     |0.034          |0.047             |0.018   |
   |500000   |0.116    |0.092     |0.2            |0.273             |0.093   |
   |1000000  |0.207    |0.254     |0.476          |0.657             |0.19    |
   |5000000  |1.219    |1.213     |4.315          |4.518             |1.094   |

2. Performance results for deletion operations:

   |Size     |Ascending|Descending|RND with copies|RND without copies|Mountain|
   |---------|---------|----------|---------------|------------------|--------|
   |100000   |0.013    |0.012     |0.03           |0.038             |0.011   |
   |500000   |0.068    |0.07      |0.201          |0.244             |0.07    |
   |1000000  |0.139    |0.151     |0.548          |0.742             |0.145   |
   |5000000  |0.753    |0.834     |4.281          |4.879             |0.842   |

3. Performance results for search operations:

   |Size     |Ascending|Descending|RND with copies|RND without copies|Mountain|Mutated|
   |---------|---------|----------|---------------|------------------|--------|-------|
   |100000   |0.009    |0.009     |0.019          |0.027             |0.008   |0.031  |
   |500000   |0.05     |0.052     |0.141          |0.157             |0.044   |0.195  |
   |1000000  |0.103    |0.101     |0.346          |0.495             |0.091   |0.348  |
   |5000000  |0.452    |0.599     |2.691          |3.21              |0.57    |2.761  |

---

## Counting Sort Algorithm test conditionals

Counting Sort has a time complexity of O(n+k), where n is the number of elements in the input array and k is the range of the input values. 
Counting Sort performs well when the range of input values (k) is relatively small compared to the number of elements (n). 
However, Counting Sort may not perform well when we have large range of input values.

|Size     |RANGE:1000000|RANGE:5000000|RANGE:10000000|
|---------|-------------|-------------|--------------|
|1000000  |0.029        |0.087        |0.143         |
|5000000  |0.163        |0.512        |0.605         |
|10000000 |0.389        |1.031        |1.332         |

If the range of input values (k) is significantly larger than the number of elements (n), 
Counting Sort requires a large amount of memory to accommodate the count array. 
This can be inefficient and impractical in terms of memory usage.
