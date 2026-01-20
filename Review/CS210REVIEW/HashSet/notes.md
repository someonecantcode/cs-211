# HashSet

* Data structure set that does not allow duplication.
* There is no index and no specific order.
* It is a set and it hashs the data with a "hash function/table" that allows the computer to find the memory address (look up table) to the values.

* HASHSETS ARE REFERENCES OH NOES

```java
HashSet<String> hs = new HashSet<String>();

hs.add("bobby");
hs.add("google");
hs.add("samsung");

System.out.println(hs);

for(String s : hs){
    System.out.print(s);
}
```

| Methods        | Return    |
| -------------- | --------- |
| `hs.add(Object o)` | void       |
| `hs.contains(Object o)` | boolean |
| `hs.remove(Object o)` | boolean |
| `hs.size()` | int |

## Set Operations

** **

*OPERATIONS WILL MODIFY THE STATE*

Let $$ A = \{1,2,3\} \\ B = \{3,4,5\} $$

```java
HashSet<Integer> A = new HashSet<Integer>();
A.add(1);
A.add(2);
A.add(3);

HashSet<Integer> B = new HashSet<Integer>();
B.add(3);
B.add(4);
B.add(5);
```

Union of A & B $$ A \cup B = \{ 1,2,3,4,5\}$$

```java
A.addAll(B) // A new state
```

Intersection of A & B $$ A \cap B = \{ 3\}$$

```java
A.retainAll(B) // A new state
```

Difference of A - B (order matters) $$ A - B = \{1,2 \} $$

```java
A.removeAll(B) // A new state
```

$$ B - A = \{ 4,5 \} $$

```java
B.removeAll(A) // A new state
```

Symmetric Difference  $$A \Delta B = \{1,2,3,4\} $$

```java
HashSet<Type> middle = Intersect(A,B);
HashSet<Type> cloneA = 

Symmetric Difference = ()

```

## Copy/Clone a set

```java
CS210.addAll(cs211); // don't do this. you'll modify the original one


// COPYING
Set<T> temp = new HashSet<>(CS210);
HashSet<String> temp = new HashSet<>(CS210);

HashSet<String> temp = new HashSet<>();
temp.addall(CS211);


// CLONING

Set<T> temp = (Set<T>CS210.clone());
temp = (HashSet) CS210.clone(); 
// downcast from Object to Hashset (advanced) leads to unchecked warning
// Hashset.clone() creates a SHALLOW COPY. REFERENCE

```
