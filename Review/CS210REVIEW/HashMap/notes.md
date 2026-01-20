# HashMap

GREAT O(1) Average! and O(n) space.

You can put user defined classes in the types for values.

```java
HashMap<K, V> hm = new HashMap<>();
// let K and V be Integer.

hm.put(1, 2);
for(int n : hm.keySet()) {
    System.out.println(hm.get(n));
}

for(int n : hm.values()) {
    System.out.println(n);
}

hm.remove((Object) 1, (Object) 2); // returns boolean
```

| Methods        | Return    |
| -------------- | --------- |
| `hm.put(KeyType a, ValueType b)` | ValueType       |
| `hm.get(Object key)` | ValueType       |
| `hm.size()` | int       |
| `hm.containsKey(Object o)` | void |
| `hm.containsValue(Object o)` | void |
| `hm.clear()` | void |
| `hm.remove(Object o)` | ValueType |
| `hm.remove(Object key, Object value)` | boolean |
| `hm.keySet()` | Set<K> |
| `hm.values()` | Set<V> |