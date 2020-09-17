### Another three smells

* Long method
* Conditional complexity
* Large class

--

## Smell Four: Long Method

+ How long should a method be?
+ Most readable if ten lines at the most

Notes: Companies tend to have a couple of KLOC methods kicking around  

--

## Recognising Long Methods

+ Having to scroll…
+ Count the lines?

--

## How do methods grow to be too long?

+ Method starts small
+ I’ll just add one line…
+ I’ll just add one line…
+ I’ll just add one line…
+ It’s pretty long… one more line won’t hurt…

--

```java
    public static String formatDate(String reminderDate) {
        String dateDay = reminderDate.substring(8, 10);
        String dateMonth = reminderDate.substring(5, 7);
        String dateYear = reminderDate.substring(2, 4);
        String[] month = new String[]{"", "Jan", "Feb", "Mar", "Apr", "May",
                "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
 
        if (ZERO.equals(dateMonth.substring(0, 1))) {
            dateMonth = dateMonth.substring(1, 2);
        }
        String displayMonth = month[Integer.parseInt(dateMonth, 10)];
 
        String pattern = "";
        if (ONE.equals(dateDay) || TWENTY_ONE.equals(dateDay)
                || THIRTY_ONE.equals(dateDay)) {
            pattern = "st";
        } else if (TWO.equals(dateDay) || TWENTY_TWO.equals(dateDay)) {
            pattern = "nd";
        } else if (THREE.equals(dateDay) || TWENTY_THREE.equals(dateDay)) {
            pattern = "rd";
        } else {
            pattern = "th";
        }
 
        if (ZERO.equals(dateDay.substring(0, 1))) {
            dateDay = dateDay.substring(1, 2);
        }
 
        return dateDay + pattern + " " + displayMonth + " " + dateYear;
    }
```

--

## How to fix Long Methods

+ Extract method
+ Replace temporary variable with query
+ Introduce parameter object
+ Decompose conditional (i.e. extract methods)
+ Replace method with method object

--

## Smell Five: Conditional complexity

+ Deeply nested `if else` statements
```
if (!model.matches(".*\\d+.*")) {
    if (model.length() < 4) {
        model = model.toUpperCase();
    } else if (model.charAt(2) == ' ') {
        model = model.substring(0, 3).toUpperCase() + initCap(model.substring(3));
    } else {
        model = initCap(model);
    }
}
```
+ code can be wide as well as long
+ `switch` statements

--

## No `if`s no buts or `else`!

+ How many conditionals are acceptable?
+ Be _if-ist_
+ Frequently seen in the wild

Notes:
Highlight the opposing points of view form OO purists to common attitudes.  

--

## How to resolve conditional complexity

+ Extract method
+ Replace conditional with polymorphism

--

```java
class Vehicle {
    String vehicleType;
}

...

if (vehicleType.equals("CARS") {
    return "Vehicle Check Available";
} else if (vehicleType.equals("BIKE") {
    return "Vehicle Check Coming Soon!";
} else {
    return "Vehicle Check Unavailable";
}
```

--

```java
class Vehicle {
    String getVehicleCheckStatus(){
        return "Vehicle Check Unavailable";
    }
}
class Car extends Vehicle{
    String getVehicleCheckStatus(){
        return "Vehicle Check Available";
    }
}
class Bike extends Vehicle{
    String getVehicleCheckStatus(){
        return "Vehicle Check Coming Soon!";
    }
}
```

--

```java

if (vehicleType.equals("CARS") {
    return "Vehicle Check Available";
} else if (vehicleType.equals("BIKE") {
    return "Vehicle Check Coming Soon!"
} else {
    return "Vehicle Check Unavailable";
}
```
vs

```java
vehicle.getVehicleCheckStatus();
```

--

## Smell Six: Large Class

+ Similar to a long method
+ Too many fields
+ Too many methods
+ Too many lines of code
+ Too many responsibilities
+ Duplication is likely

<backgroundimage>https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Textured_spork.png/512px-Textured_spork.png</backgroundimage>
<!-- .slide: data-background-size="512px 512px" -->
<!-- .slide: data-background-repeat="repeat" -->
<!-- .slide: data-background-opacity="0.3" -->


<div style="font-size: 0.25em">
    Spork.jpg: Jason L. Gohlkederivative work: Plasticspork [<a href="https://creativecommons.org/licenses/by-sa/2.5">CC BY-SA 2.5</a>], <a href="https://commons.wikimedia.org/wiki/File:Textured_spork.png">via Wikimedia Commons</a>
</div>


--

## How do large classes happen?

+ Similar to long methods
    * They grow over time
+ Indicate an absence of refactoring
+ Not knowing how to decompose responsibility

--

## How to fix them?

+ Split them up
+ Extract class(es)
+ Move method(s)
+ Use inheritance
    * Extract super class or subclass

Note: First step must be to establish what should be the true single responsibility.  
    With a large class more responsibility will have crept in.  
    Work that out, then move the rest elsewhere.  
    Might be too confused to refactor.  

--


## Exercise: address these smells (60 mins)

* Address them one at a time:  
  Long method, Conditional complexity, Large class
+ After each change, run all of the tests
+ Commit if green
+ Revert if red


Notes:
Keep changes small  
Commit little and often  
Keep running the tests  