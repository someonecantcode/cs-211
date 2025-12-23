# Stacks & Queues Review

* Stacks are LIFO like plates.
* Queres are FIFO like lines.

## Stacks

Head Index is **starts at 1**


![example stack](stack.png)

```java
Stack<Integer> myStack = new Stack<>();

myStack.push(1);
myStack.push(4);
myStack.push(9);

System.out.println(myStack); // Stacks have a toString(). [1, 4, 9]
myStack.pop(); // REMOVES 9 and returns 9. myStack = [1, 4]

System.out.println(myStack.peak()); // returns 4
System.out.println(myStack.pop()); // REMOVES 4 and returns 4.

System.out.println(myStack); // [1]
System.out.println(myStack.isEmpty()); // false

System.out.println(myStack.search(1)); // 1
System.out.println(myStack.search(9)); // -1 NOT FOUND
```


| Methods                | Return  |
| ---------------------- | ------- |
| `empty()`      | `boolean`   |
| `peek()`      | `E` |
| `pop()`      | `E` |
| `push(E item)`     | `E` |
| `search(Object o)`     | `int` |