package heap;

import java.util.PriorityQueue;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MinHeap {

    public static void main(String[] args) {
        int[] ar = { 1000, 100, 458, 45, 2000, 12, 0, 12, 78, 96, 987, 1 };

        List<Integer> arr = Arrays.stream(ar).boxed().collect(Collectors.toList());
        PriorityQueue<Integer> minHeap = minHeap(arr);

        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }

    public static PriorityQueue<Integer> minHeap(List<Integer> arr) {
        PriorityQueue<Integer> minpq = new PriorityQueue<>(arr.size());
        minpq.addAll(arr);
        return minpq;
    }

}
