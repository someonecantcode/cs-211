# Time Complexity
>
> Based on number of statements being run. NOT CPU TIME

* We remove constants and coefficients.

```java
void ex1(int n) { 
    int count = 0; // 1
    int i; // 1
    for(int i = 0; i < n; i++) { // n + 1 (+1 for the last check)
        count++; // n
    }
}
// Total Execution Time: 1 + 1 + (n+1) + n = 2n+3
// Take the largest and remove constants + coefficients
// O(n)
```