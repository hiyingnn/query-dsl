# API

### Jackson Deserialisation

### Missing fields

1. boolean (primitive): default fallback value of false
2. String: default fallback value of null
3. Object: default fallback value of null

1. Using Jackson Setter (can also be set globally via configurations)

```java
@JsonSetter(nulls= Nulls.AS_EMPTY)
String duration;

@JsonSetter(nulls= Nulls.AS_EMPTY)
List<String> skills;
```

- fields that are explicitly null will be mapped:
  - String: to “”
  - Collections: to empty
- **However, missing values will not be mapped to their default fallback values**
1. Using Jackson Setter with default values

```java
@JsonSetter(nulls= Nulls.AS_EMPTY)
String duration = "";

@JsonSetter(nulls= Nulls.AS_EMPTY)
List<String> skills = List.of();
```

- This will cover both cases of missing values and explicitly null values.
- However, there is an overhead to declare the default values

Resources:

[https://stackoverflow.com/questions/18805455/setting-default-values-to-null-fields-when-mapping-with-jackson](https://stackoverflow.com/questions/18805455/setting-default-values-to-null-fields-when-mapping-with-jackson)
