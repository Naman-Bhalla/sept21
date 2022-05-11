package mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MergeSort implements Callable<List<Integer>> {
    List<Integer> list;

    MergeSort(List<Integer> list) {
        this.list = list;
    }

    @Override
    public List<Integer> call() throws Exception {
        if (this.list.size() == 0) {
            return new ArrayList<>();
        }

        if (this.list.size() == 1) {
            return this.list;
        }

        // 0 1 2 3 4 5

        int n = this.list.size(); // 2 mid = 1
        int mid = n/ 2; // 1 {1, 2}

        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        for (int i = 0; i < mid; ++i) {
            leftArray.add(this.list.get(i));
        }

        for (int i = mid; i < n; ++i) {
            rightArray.add(this.list.get(i));
        }

        MergeSort leftMergeSort = new MergeSort(leftArray);
        MergeSort rightMergeSort = new MergeSort(rightArray);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<List<Integer>> leftSortedFuture = executor.submit(leftMergeSort); // implicitly calling call method
        Future<List<Integer>> rightSortedFuture = executor.submit(rightMergeSort);

        List<Integer> mergedArray = new ArrayList<>();

        // wait till the future object returns the value
        List<Integer> leftSorted = leftSortedFuture.get();
        List<Integer> rightSorted = rightSortedFuture.get();

        int i = 0;
        int j = 0;

        while (i < leftSorted.size() && j < rightSorted.size()) {
            if (leftSorted.get(i) < rightSorted.get(j)) {
                mergedArray.add(leftSorted.get(i));
                i++;
            } else {
                mergedArray.add(rightSorted.get(j));
                j++;
            }
        }

        while (i < leftSorted.size()) {
            mergedArray.add(leftSorted.get(i));
            i++;
        }

        while (j < rightSorted.size()) {
            mergedArray.add(rightSorted.get(j));
            j++;
        }

        return mergedArray;
    }
}

// Assignment: Implement Quick Sort in Java
// Break till 10:30 PM