# Managementul unei Biblioteci Digitale
## Girnet Andrei

## Descriere
Acest proiect este creat pentru a fi in stare sa administrezi o biblioteca digitala

Ce face acest program:
* Intoarce toate cartile publicate de un retailer
* Intoarce toate limbile in care sunt publicate cartile unui retailer
* Intoarce toate tarile unde a fost publicata o carte
* Intoarce cartile comune intre 2 retaileri
* Intoarce toate cartile (reuniune) intre 2 retaileri

---
## Functionalitatea
Toate cartile, autorii si legaturile dintre carti autori, etc se scriu in fisierele din folderul init, si apoi toate manipularile au loc cu ajutorul clasei Administration.

Pentru a citi din fisier folositi metodele statice din MyFileReader, in felul urmator:
```java
class Program{
    
    // Initializarea tuturor variabilelor cu date din fisier
    MyArrays languages = MyFileReader.readFromFile("./init/languages.in",1);
    MyArrays books = MyFileReader.readFromFileBook("./init/books.in", languages);
    MyArrays authors = MyFileReader.readFromFile("./init/authors.in",0);
    MyArrays countries = MyFileReader.readFromFile("./init/countries.in",2);
    MyArrays editorialGroups = MyFileReader.readFromFile("./init/editorial-groups.in",3);
    MyArrays publishingBrands = MyFileReader.readFromFile("./init/publishing-brands.in", 4);
    MyArrays publishingRetailers = MyFileReader.readFromFile("./init/publishing-retailers.in",5);

    // Conectarea tuturor datelor intre ele
    MyConnection.connectionBetweenAB("./init/books-authors.in",books,authors,0);
    MyConnection.connectionBetweenAB("./init/editorial-groups-books.in",editorialGroups,books,1);
    MyConnection.connectionBetweenAB("./init/publishing-brands-books.in",publishingBrands,books,2);
    MyConnection.connectionBetweenAB("./init/publishing-retailers-books.in",publishingRetailers,books,3);
    MyConnection.connectionBetweenAB("./init/publishing-retailers-countries.in",publishingRetailers,countries,4);
    MyConnection.connectionBetweenAB("./init/publishing-retailers-editorial-groups.in",publishingRetailers,editorialGroups,5);
    MyConnection.connectionBetweenAB("./init/publishing-retailers-publishing-brands.in",publishingRetailers,publishingBrands,6);

} 

```
Clasa Administration primeste la constructor toti retailerii

```java

    Administration administration = new Administration(publishingRetailers);

```

### <b>Metodele de prelucrare a unei biblioteci:</b>
* <b>getBooksForPublishingRetailerID</b>

```java

    /**
    * Intoarce toate cartile publicate de un retailer, verifica de asemenea si 
    * grupul editorial si brandul pentru carti
    * @param publishingRetailerID Id-ul retailerului
    * @return Toate cartile fara repetitii
    **/
    MyArrays testBooksPR = administration.getBooksForPublishingRetailerID(publishingRetailerID);

```

* <b>getLanguagesForPublishingRetailerID</b>

```java
    
    /**
    * Intoarce toate limbile in care are carti un retailer
    * @param publishingReatilerID Id-ul retailerului
    * @return Toate limbile fara repetitie
    **/
    MyArrays testLanguagesPR = administration.getLanguagesForPublishingRetailerID(publishingRetailerID);

```

* <b>getCountriesForBookID</b>

```java

    /**
    * Intoarce toate tatile in care a fost publicata cartea
    * @param bookID ID-ul cartii
    * @return Toate tarile fara repetitie
    **/
    MyArrays testCountryB = administration.getCountriesForBookID(bookID);

```

* <b>getCommonBooksForRetailerIDs</b>

```java
    
    /**
    * Intoarce toate cartile comune intre 2 retaileri(O(n+m))
    * @param retailerID1 Primul retailer
    * @param retailerID2 Al doilea retailer
    * @return Toate cartile comune fara repetie
    **/
    MyArrays testCommonPR = administration.getCommonBooksForRetailerIDs(retailerID1,retailerID2);

```

* <b>getAllBooksForRetailerIDs</b>

```java
    
    /**
    * Intoarce toate cartile pentru 2 retaileri
    * @param retailerID1 Primul retailer
    * @param retailerID2 Al doilea retaile
    * @return Toate cartile fara repetie
    **/
    MyArrays testAllPR = administration.getAllBooksForRetailerIDs(retailerID1,retailerID2);

```