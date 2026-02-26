# Hashing

* All data needs memory to store a value. 
* The memory has a location.

Hash table does not save the value of data, only the memory location.
Basically is a table of links to the memory locations.

| input    | memory address |
| -------- | ------- |
| "one"  | m1    |
| "two" | m2     |
| "three"    | m3    |


| memory address    | data value |
| -------- | ------- |
| m1  | 1    |
| m2 | 2     |
| m3    | 3    |


* Hash not allow duplicate key value because a function will always return same value with one input. (vertical line test)
* It is more efficient to write once than to check if there is a duplicate.
$f(input) = output$