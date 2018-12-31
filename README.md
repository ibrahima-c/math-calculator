# Mathematical expression calculator


This project uses the [mathematical expression parser](https://github.com/ibrahima-c/math-parser) to evaluate math expressions.

It has also a graph tool that is used in the [mathematical expression plotter](https://github.com/ibrahima-c/math-plotter).

### Syntax of the calculator

```java
        IMath math;
        Double result = null;

        try {
            math = new Math( "2*x * (2*y+1) + cos(pi*z) " );
            math.setArgValue( 'x', 2.0 );
            math.setArgValue( 'y', 2.0 );
            math.setArgValue( 'z', 1.0 );
            result = math.getValue();
        } catch ( ParenthesisException | MathFunctionException | DivisionException e ) {
            System.out.println( e.getMessage() );
        }

        System.out.println( "The result is " + result );
```

- The value of an argument can be set by calling the method `setArgValue(Character argName, Double value )`

```java
            math = new Math( "2*x * (2*y+1) + cos(pi*z) " );
            math.setArgValue( 'x', 2.0 );
            math.setArgValue( 'y', 2.0 );
            math.setArgValue( 'z', 1.0 );
```

- Or by calling the method `setArgValue(Integer argPosition, Double value )`

```java
            math = new Math( "2*x * (2*y+1) + cos(pi*z) " );
            math.setArgValue( 1, 2.0 ); // for x
            math.setArgValue( 2, 2.0 ); // for y
            math.setArgValue( 3, 1.0 ); // for z
```

### Syntax of the graph tool

```java
        IGraph graph;

        Double xmin = 0.0;
        Double xmax = 10.0;
        Integer nbPoints = 1000;

        Double[] xaxis = new Double[nbPoints];
        Double[] Fx = new Double[nbPoints];

        try {
            graph = new Graph( "cos(pi*x)*exp(-x)", xmin, xmax, nbPoints );
            xaxis = graph.getXaxis();
            Fx = graph.getFx();
        } catch ( MathFunctionException | DivisionException | ParenthesisException e ) {
            System.out.println( e.getMessage() );
        }
```