# Find the celebrity

## Suppositions

* A celebrity could know himself or not ¯\_(ツ)_/¯
* Could be no celebrities at the party
* There is no party with only 1 person

## Executing

There are three ways to run the application:

1. Reading input from console:

    ```
    java com.reiterweg.findthecelebrity.FindTheCelebrity
    ```

2. Reading input from file relative to classpath:

    ```
    java -DfilePath=file.txt com.reiterweg.findthecelebrity.FindTheCelebrity
    ```

3. Reading input from file from absolute path:

    ```
    java -DfilePath=/home/reiterweg/file.txt -Dabsolute=true com.reiterweg.findthecelebrity.FindTheCelebrity
    ```


## Testing
To launch your application's tests, run:

```
mvn test
```

