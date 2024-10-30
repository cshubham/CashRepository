Brief Solution Glimpse -
- check initial amounts available, if the required amount if not available return exception
- then calculate difference of change to be return
- created and extension function on Change, which check from given change object, how much coins are present, and since less coins needs to be returned, we sorted descending and pick biggest coin first, check how many coins should be given, add coins to a map(until change to give is > 0) , do this in a loop until change is acheived. If change not acheived return emptyMap else filled map
- if map is empty throw exsception since transcatuon didnt succeed, else use map to remove those coins from change object and add it our return object and return change
- EXTRAS - so at last we need add the input MonetaryElement to cash register after giving change but .. we dont know whats the input MonetaryElement and their units so didnt performed this steps but mentioned in code.







# Adyen Kotlin Assignment

This repository contains the coding assignment for candidates applying for a Kotlin Engineer role at Adyen.
The goal of the assignment is to implement a cash register.

Criteria:
- The `CashRegister` gets initialized with some `Change`.
- When performing a transaction, it either returns a `Change` object or fails with a `TransactionException`.
- The `CashRegister` keeps track of the `Change` that's in it.

Bonus points:
- The cash register returns the minimal amount of change (i.e. the minimal amount of coins / bills).

Feel free to make any changes to the code in the assignment.
As part of the zip file you received is the local Git repository, you can use that to show us your development and thought process in the commit history.


