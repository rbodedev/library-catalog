# library-management-program
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
After the libarian has logged into the system, the libarian will be provided with a number of command options:

    1. ADD: The librarian can add a book to the library catalog.

    2. CHECKIN: This command allows the librarian to check a checked out book back into the library management program.

    3. REMOVE: The remove command allows the user to remove a book by title.

    4. SEARCH: Librarians can search for a book by any portion of the title.

    5. LIST: Using the list command displays the entire libary catalog.

    6. SAVE: This option saves the current library catalog with quantity available.

    7. EXIT: entering exit will exit the libary management system.

