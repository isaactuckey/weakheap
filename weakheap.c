// Isaac Tuckey (4996772)
// COT-5402, Spring 23



int Gparent(int j, int* reverse) {
    while (odd(j) == reverse[j/2]) {
        j = j/2;
    }
    return j/2;
}

void Merge (int* i, int* j) {

}

weakheap * weakHeapify(int n, int* arr) {
    // Initialize arrays and allocate memory
    weakheap * ret = malloc(sizeof(weakheap));
    ret->h = calloc(n+1, sizeof(int));
    ret->reverse = calloc(n+1, sizeof(int));




}

void weakHeapSort(int n, int *h) {
    weakHeapify(n, h);
}

int main(void) {
    return 0;
}

