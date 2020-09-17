## Code Smells

(but not all code)

--

## Purpose:

### Provide language to discuss problems

+ Less ambiguous if language is shared
+ Takes ego away from conversation
+ Helps you identify issues
+ Suggests resolutions

--

> A code smell is a hint that something has gone wrong somewhere in your code. Use the smell to track down the problem.  
>   
> Note that a CodeSmell is a hint that something might be wrong, not a certainty.  
—http://wiki.c2.com/?CodeSmell

--

<backgroundimage>https://upload.wikimedia.org/wikipedia/commons/5/55/Kent_Beck_no_Workshop_Mapping_XP.jpg</backgroundimage>
<backgroundimageopacity>0.5</backgroundimageopacity>
<!-- .slide: data-background-position="top" -->

Originated from Kent Beck’s [Once And Only Once](http://wiki.c2.com/?OnceAndOnlyOnce) rule.  
(see also [CodeSmell](http://wiki.c2.com/?CodeSmell)).

> The program should express each idea once and only once - there should be no duplicate code.

<small>
[This file](https://www.flickr.com/photos/8512982@N05/1574023621/) is licensed under the Creative Commons [Attribution-Share Alike 2.0 Generic](https://creativecommons.org/licenses/by-sa/2.0/deed.en) license.
</small>

Note: Kent also created extreme programming, helped form the Agile Manifesto, is the leading proponent of TDD, spawned unit testing frameworks and popularised CRC cards.  
  OAOO similar to DRY but subtly different  

--

<img src="{{ site.github.url }}/images/Refactoring-Improving-the-Design-of-Existing-Code.jpg">

Further developed and popularised by Martin Fowler 

--

> If it stinks, change it.

_\- Grandma Beck, discussing child-rearing philosophy*_

+ Things can smell ‘off’ without knowing why: ‘the sniff test’
+ Your sense of smell will improve

<div style="font-size:0.25em">
    * Martin Fowler - Refactoring
</div>

Notes: Everyone has a sense of smell  
  Can become more refined  
  Can’t always tell what something is  
  Can usually tell if it smells good or bad  

--

## No single definitive list of smells

You’ll find smells referenced in one list which aren’t described in another 

Notes: Conventions have appeared over the years.  
  You may recognise some of them.  

--

## Upcoming exercise…

+ Explore *some* smells
+ Practice addressing them

---

<backgroundimage>images/qwan-refactoring-cards.jpg</backgroundimage>
<backgroundimageopacity>0.3</backgroundimageopacity>

## QWAN Refactoring Cards

Notes: Going to be using QWAN Refactoring Cards  

--

<img src="{{ site.github.url }}/images/smells-refactoring-cards-sample.png">

## Two types of card

+ Smell cards: help you identify the smell and suggest solutions
+ Refactor cards: explain what the suggested refactors achieve

Notes: Using the cards levels the playing field  
    Less speculation  
    Less ego  

--

## How to use the QWAN Cards

+ When you find something that smells, find the appropriate card
+ Place the card down, and read the advice
+ Find the refactors it references
+ Pick the appropriate refactor and place it next to the smell card
+ Carry out your refactor
+ Continue reading and start again

--

### https://sourcemaking.com/refactoring/smells

+ Excellent resource
+ Alternative to the cards
+ Goes into more detail
+ Use the cards but feel free to explore website if you need more detail

--

## First three smells

+ Uncommunicative Name
+ Duplicate Code
+ Magic Number

---

## Smell One: Uncommunicative Name

> Naming things is hard

<div style="font-size:0.25em">\- https://martinfowler.com/bliki/TwoHardThings.html</div>

+ Bad names make things difficult to understand
+ May indicate a poor design

--

## Recognising bad names

+ single letter names
+ abbreviations
+ technical names

--

```
boolean containsLabel(String name, List labels) {
    for (int i = 0; i < labels.size(); i++) {

        if ((labels.get(i).name.toLowerCase())
                .equals(name.toLowerCase())) {
            return true
        }
    }

    return false
}
```

--

## How to fix bad names?

+ Erm... rename things
+ Variables
+ Methods
+ Classes

---

## Smell Two: Duplicate Code

+ This is a tricky one
+ Easiest to get wrong
+ Duplicate lines
+ Duplicate methods
+ Duplicate files
+ Duplicate knowledge

--

## Where does duplication come from?

+ Not knowing something already exists
+ Failing to extract constants
+ Copy pasta
+ Wanting something similar, but slightly different
+ Not understanding how to encapsulate knowledge in one place
+ Being in a hurry—introducing duplication is quicker
+ Being interrupted during proper work flow
    + Best to introduce duplication first then address it 

--

```java
protected Redirect validRequest(Context request) {
    Uri uri = request.getUri();
    String dealer = uri.getParameter("dealer").trim();
    String type = uri.getParameter("type").trim();
    …
    return new InternalRedirect(redirectUri);
}
protected Redirect invalidRequest(Context request) {
    String dealer = request.getUri().getParameter("dealer").trim();
    String type = request.getUri().getParameter("type").trim();
    …
    return new InternalRedirect(redirectUri);
}
```

Notes: Where is the duplication?

--

## Addressing duplication

+ Extract Variable / Method / Class
+ Pull Up Method
+ Form Template Method

---

## Smell Three: Magic Number

+ Literal values in the code
+ Can’t understand meaning of the number from it’s value
+ e.g. OxDEADBEEF, 3.14159

Notes: First is a famous IBM error code, second is Pi  

--

## Why do we end up with magic numbers?

+ Sometimes natural way to write expressions
+ Don’t anticipate duplication
+ We know what the number means when we write it

--

## Recognising Magic Numbers

+ Can see literal values in the code
+ The magic numbers may be duplicated

--

```java
    public static Page from(String... pageIds) {
        if (pageIds.length == 2) {
            return from(pageIds[0], pageIds[1]);
        }
        return from(pageIds[0], "");
    }

    private boolean isInvalid(int statusCode) {
        return statusCode < 200 || statusCode >= 300;
    }
```

--

```java
    public void addManufacturedYear(Vehicle vehicle) {
            Optional.ofNullable(vehicle)
                    .map(Vehicle::getManufacturedYear)
                    .filter(yearValue -> yearValue.toString().length() == 4)
                    .ifPresent(keyFactsMap::addManufacturedYear);
    }

```

--

## Fixing Magic Numbers

+ Extract value of the number to a well named constant
+ Careful: not every use of a literal has the same meaning!

--

## Recap

+ Uncommunicative Name
+ Duplicate Code
+ Magic Number

Notes: Don’t worry… all on the cards

--

## Coverage

+ Covering this code is not in scope  
+ We’ve covered the code with single exhaustive test
+ Test is interesting, but not part of today’s learning
+ If tests help you, feel free to add them

--

## Exercise: address these smells (60 mins)

+ Address them one at a time:  
  Uncommunicative Name, Duplicate Code, Magic Number
+ After each change, run all of the tests
+ Commit if green
+ Revert if red

Notes: If working in small chunks reverting not a big deal  
    Remember you can have tests running automatically in IntelliJ  
    Run *all* of the tests  