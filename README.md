# library-catalog
This program is a library management system allowing users to checkout books and track the book inventory in real-time.

There are two levels of user tiers:
    
    client:
        Any visitor of the library can utilize the client version of the program to check out books.
        Clients are limited to this checkout process only.
    
    librarian:
        To access the librarian mode a user should enter "librarian" in the book title entry line.
        After entering librarian the user will be prompted for a password (the password is pw).

client workflow:
The user should enter the title of the book they wish to checkout. If there are no books available, the program will advise the user there are no books available.
If the title is available, the system will notify the user that the checkout was successful.

librarian workflow:
