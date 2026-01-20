# Time & Space Complexity and Big O Notation Review

## Disclaimers

>Big O notation may give great insight on what algorithms to pick and additionally pinpointing bottlenecks in your code. However, Big O Notation only gives asymptotic behavior and thus does not bring into the full picture of initial time (removing coefficients and constants) and short term behavior. For example, HashMaps have an exceptional O(1) time complexity but has a larger constant start up cost. Hence, for smaller datasets, it may be better to use a faster datastructure for that smaller use case only.

## Big O Notation

When we want to compare algorithms with one another, what criteria should we use? The answer is Big O notation. Big O notation in math is the general asymptopic behavior of a function. It can be used to understand the general behavior of limits and series. This analysis of seeing how ***functions behave over long periods of time*** also extends to algorithms.

We can classify each statement and algorithm by the following general equations:

* $O(1)$:        Constant Time
* $O(\log(n))$:  Logarithmic Time
* $O(n)$:        Linear Time
* $O(n\log(n))$: Linearithmic Time
* $O(n^c)$:      Polynomial Time
* $O(c^n)$:      Exponential Time
* $O(n!)$:       Factorial Time

![Big O Complexity Chart](bigO.jpg)

The process of classifying an algorithm is to take the **largest, worse case time complexity**. After you have the largest time complexity, chop off constants and coefficients.

> Here is an example:

```java
void example1(int n){
    int count = 0; // O(1)
    int i ; // O(1)
    for (int i = 0; i < n ; i++){ // O(n+1) 
        count++; // O(n) happens everytime with the for loop
    }
}
// Total Execution Time: 
// 1+1+(n+1)+n = 2n + 3 = O(n)
```

# Sorting alg stuff

Here are some algorithms used in sorting. You can compare the time complexities and see how we calculate each case.

## Selection Sort $O(n^2)$

Find the smallest number in an array, placing it in the very front. Now you have a "smaller array" and keep repeating this process. You should see that you are doing n comparisons for the first round (because size of array is n), n-1 for second round, . . . until 1. So summing it all up, n+(n-1)+...+1 is the sum of natural numbers from to 1 to n.

So basically $\sum_{i=1}^{n} i = \frac{(n)(n+1)}{2}$ So $\frac{n^2}{2} + \frac{n}{2} $ results in $O(n^2)$

![selection sort](sorting/selection.png)

Code implementation:

```java
// Rearranges the elements of a into sorted order using​
public static void selectionSort(int[] a) {​
    for (int i = 0; i < a.length - 1; i++) {​
    // find index of smallest remaining value​
        int min = i;​
        for (int j = i + 1; j < a.length; j++) {​
            if (a[j] < a[min]) {​
                min = j;​
            }​
        }​

    // swap smallest value its proper place, a[i]​
    swap(a, i, min);​
    }​
}​
```

## Insertion Sort $O(n^2)$

You basically have a smaller sorted partition in the array and keep placing in the correct position of that smaller portion until it is the entire array.

Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands. The array is virtually split into a sorted and an unsorted part. Values from the unsorted part are picked and placed at the correct position in the sorted part.​

Algorithm​
To sort an array of size n in ascending order:​
1. Iterate from arr[1] to arr[n] over the array.​
2. Compare the current element (key) to its predecessor.​
3. If the key element is smaller than its predecessor, compare it to the elements before. Move the greater elements one position up to make space for the swapped element.​

![insertion sort image](sorting/insertion.png)

Code Implementation:
>
> Taken from geeksforgeeks.

```java
public static int[] insertionsort(int[] a){
    for(int i = 0; i < a.length; i++) {
        int key = a[i];
        int j  = i - 1;
        // place the item in the correct
        while(j >= 0 && arr[j] > key) { // its already sorted so we can just do it like this. change > to < if you want max.
            arr[j+1] = arr[j];
            j = j - 1;
        }
        arr[j+1] = key;
    }
}

```

## Merge Sort $O(n\log(n))$

Take two lists and take each number one at a time. Compare which number is smaller and add it to the list and move through the list for the number you added. Merge sort does this by spliting it up and then combining it at the end.

In other words, repeatedly divide the data in half, sort each half, and combine the sorted halves into a sorted whole.

![alt text](sorting/merge.png)

```java

public static int[] merge2sortedlists(int[] a, int[] b) {
    int p0 = 0;
    int p1 = 0;

    int totalsize = a.length + b.length;
    int currentindex = 0;
    int[] answer = new int[a.length + b.length];
    // while(p0+p1 < totalsize){
    //     if ((a[p0] > b[p1])) {
    //         answer[currentindex] = a[p0];
    //         p0++;
    //     } else {
    //         answer[currentindex] = b[p1];
    //         p1++;
    //     }
    //         currentindex++;
    // }

    while (p0 < a.length && p1 < b.length) {
        if (a[p0] <= b[p1]) {
            answer[i++] = a[p0++];
        } else {
            answer[i++] = b[p1++];
        }
    }

    // Copy remaining elements of a
    while (p0 < a.length) {
        answer[i++] = a[p0++];
    }

    // Copy remaining elements of b
    while (p1 < b.length) {
        answer[i++] = b[p1++];
    }

    return answer;
}


public static int[] mergesort(int[] a){
    if (a.length <= 1) {
        return a;
    }
    // take the left and right and keep spliting and combine
    
    // we need the first left half and the second righ thalf
    int mid = a.length/2;
    int[] leftside = Arrays.copyOfRange(a, 0, mid);
    int[] rightside = Arrays.copyOfRange(a, mid, a.length);
    
    return merge2sortedlists(mergesort(leftside), mergesort(rightside));
}
```

# Collections Class methods

If you want a max sorted collection, do `Collection.reverse(Collection.sort(list));`

![collections](collections.png)

| Methods                | Return  |
| ---------------------- | ------- |
| `binarySearch(list, value)`      | `boolean`   |
| `copy(listTo, listFrom)`      | `E` |
| `emptyList(), emptyMap(), emptySet()`      | `E` |
| `fill(list, value)`     | `E` |
| `max(Collection), min(Collection)`     | `int` |
| `replaceAll(list, old, new)`     | `Collection` |
| `reverse(list)`     | `Collection` |
| `shuffle(list)`     | `Collection` |
| `sort(list)`     | `Collection in Aacending Order` |