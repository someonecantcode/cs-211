# `&` and `&&` Review

> `&` & `&&` review lol

### TLDR: 
* `&` evaluates both sides of the operation or `AND` bitwise operator
* `&&` evaluates the left side of the operation, if it's `true`, it continues and evaluates the right side. Shortcuts and skips if first check is `false`.


When we are usually taught logic operators, i.e (`||`, `&&`, `!`, `==`), we don't cover `&` is until later on with bitwise operators.
The `&` symbol in java is the `AND` bitwise operator but can also be used as double evaluator.

>How could this affect behavior in code?

```java
static void And() {
    int a=1;
    int b=2;

    ​if ((a==b) & (a++==b)) { // a++ is run with &.
        ​ ​// whatever code
    }

    ​System.out.println("a= " + a + " b= " +b);
                    //  a=2 b=2
}
```

Interesting and could maybe be useful.