# Polymophism

Same code be used with different types of objects and behave differently with each.

You can use the same code for different types of objects and each behaves differently.

## Compile-time Polymorphism

Default way of initializing instance.

```java
Object myOjbect = new Object()
```

## Run-time Polymorphism

Attributes will refer to the parent super variables. Will not be able to call child own specific methods, only parent methods. **You will be able to call child overrided methods.**

```java
Parent myOjbect = new Child()
```