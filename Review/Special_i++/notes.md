# i++ & ++i Review

Becareful when you use `i++` versus `++i`.

* `i++` returns the initial value of `i` first and then increments `i` second.
* `++i` increments `i` first and then returns `i`. Basically `i=i+1`.

> Take a look below.

```java
int i = 0;

i++; 
System.out.println(i);   // 1, i = 1

System.out.println(i++); // 1, i = 2

System.out.println(++i); // 3, i = 3
```

> Now, let's do some nested tricky increment with addition and subtraction.

```java
int i = 1;

System.out.println(++i+i+++--i-i--); // 4
```

> Okay. . . . how does one even decipher this mess of code?
Let's take it step by step and use our behavior from whether `++` or `--` is in front or behind.

```java
int i = 1;
(++i) + (i++) + (--i) - (i--)

(2)   + (2)   + (2)   - (2) = 4
i=2;    i=3;    i=2;    i=1
behind front   behind  front
```

Sweet. Now you should understand `i++` and `++i` pretty well now.
