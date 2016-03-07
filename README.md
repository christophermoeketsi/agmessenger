# agmessenger


***************************************************************************
*******************THIS IS THE SPECIFICATION OF THE ***********************
******************************PROJECT**************************************
***************************************************************************
*******************This is the user file format ***************************

Ward follows Alan
Alan follows Martin
Ward follows Martin, Alan

******************* This is the message file format ***********************
Alan> If you have a procedure with 10 parameters, you probably missed some.
Ward> There are only two hard things in Computer Science: cache invalidation,
      naming things and off-by-1 errors.
Alan> Random numbers should not be generated with a method chosen at random.



*******************This is how the outout should be ***********************
Alan

@Alan: If you have a procedure with 10 parameters, you probably missed some.

@Alan: Random numbers should not be generated with a method chosen at random.

        Martin

        Ward

@Alan: If you have a procedure with 10 parameters, you probably missed some.

@Ward: There are only two hard things in Computer Science: cache invalidation,
        naming things and off-by-1 errors.

@Alan: Random numbers should not be generated with a method chosen at random.​

Assumptions that were made when making the application .
The application is not persistent - and therefore has not concept of history or state at
this given point in time .

Improvements that I wanted to make to the application
    Introduce a graph database
    Use a file watcher to pickup and load files
    Introduce multitheading to load the messages and the users (This is why I used a hashtable to store the cached users)
    Finally use websockets to, push and pull messages

