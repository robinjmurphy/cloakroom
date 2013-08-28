# cloakroom

Cloakroom is a super simple object store in Java. It lets you store an object and retrieve it at some point in the future using a token.

This project came about when writing [Cucumber](http://cukes.info/) step definitions in Java, where it's useful to be able to store objects in _when_ steps and retrieve them for assertions in _then_ steps.

## Usage

Create a Cloakroom

```java
private Cloakroom<String> cloakroom = new Cloakroom<String>();
```

Store an object and receive a token that can be used to retrieve it

```java
String line1 = "To be, or not to be, that is the question:";
Token token = cloakroom.checkIn(line1);
```

Or, store an object with a string key

```java
String line2 = "Whether 'tis Nobler in the mind to suffer";
cloakroom.checkIn("line2", line2);
```

Some time later, retrieve an object using its token

```java
String line1 = cloakroom.pickUp(token);
```

Or, by its string key

```java
String line2 = cloakroom.pickUp("line2");
```