// Isaac Tuckey (4996772)
// COT-5402, Spring 23

import java.util.Arrays;

public class Weakheap {
    // h is the 1-d array used to implement the weak heap
    private int[] h;
    // reverse[i] is the 'bit' needed to determine i's right and left child
    private boolean[] reverse;

    // Class initializer
    public Weakheap(int[] inputArray) {
        final int n = inputArray.length;
        this.reverse = new boolean[n+1];
        // We need to copy the input with an extra space to sort in place
        this.h = new int[n+1];
        for (int i = 0; i < n; i++) {
            this.h[i] = inputArray[i];
        }
    }

    // Returns the index of j's grandparent
    private int getGrandparent(int j) {
        // while: odd(j) = reverse(j/2)
        while ((j % 2 != 0) == this.reverse[j/2]) {
            j = j/2;
        }
        return j/2;
    }

    // Swaps values in h[i] and h[j]
    private void swap(int i, int j) {
        final int temp = this.h[i];
        this.h[i] = this.h[j];
        this.h[j] = temp;
    }

    // Merges two sub-weak-heaps with roots at i and j
    private void merge(int i, int j) {
        if (this.h[i] < this.h[j]) {
            swap(i, j);
            this.reverse[j] = !this.reverse[j];
        }
    }

    // Take the values in h and construct a weak-heap by merging
    private void weakHeapify(int n) {
        for (int j = n-1; j > 0; j--) {
            merge(getGrandparent(j), j);
        }
    }

    // Merge the remaining subtrees after 'removing' the root
    private void mergeForest(int m) {
        int x = 1;
        this.reverse[m/2] = false;
        if (m >= 3) {
            do {
                x = 2*x + (this.reverse[x] ? 1 : 0);
            } while (2*x + (this.reverse[x] ? 1 : 0) < m);
        }
        while (x > 0) {
            merge(m, x);
            x = x/2;
        }
    }

    // Remove the root and 
    public void weakHeapSort(int n) {
        weakHeapify(n);
        this.h[n] = this.h[0];
        for (int i = n-1; i > 1; i--) {
            mergeForest(i);
        }
    }

    // Print the array h
    public void printCurrentArray() {
        System.out.println(Arrays.toString(this.h));
    }

    public static void main(String[] args) {
        // Sample input
        int[] inputArray = new int[] {7, 82, 28, 12, 11, 56, 21, 40, 95, 67, 92, 55, 2, 8, 30, 5};
        final int n = inputArray.length;
        Weakheap heap = new Weakheap(inputArray);
        // heap.weakHeapify(n);
        // System.out.println("Heapified: ");
        // heap.printCurrentArray();
        heap.weakHeapSort(n);
        System.out.println("Sorted array in h[1...n]:");
        heap.printCurrentArray();
    }
}