import java.util.PriorityQueue;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class MaxHeap {

    public static void main(String[] args) {
        int[] ar = { 1, 2, 10, 3, 4, 5, 55, 0, 9, 100, 101, 6 };

        List<Integer> arr = Arrays.stream(ar).boxed().collect(Collectors.toList());

        PriorityQueue<Integer> maxHeap = maxHeap(arr);

        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
    }

    public static PriorityQueue<Integer> maxHeap(List<Integer> arr) {
        PriorityQueue<Integer> mpq = new PriorityQueue<>(arr.size(), Collections.reverseOrder());
        mpq.addAll(arr);
        System.out.println(mpq);
        return mpq;
    }
}
