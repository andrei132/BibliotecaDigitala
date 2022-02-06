import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Administration class, that work with Publishing Retailer
 **/
public class Administration{

    MyArrays publishingRetailers;

    public Administration(MyArrays publishingRetailers) {

        this.publishingRetailers = publishingRetailers;

    }

    /**
     * Add book from publishingRetailer that is not already in array books
     * @param publishingRetailer Publisher retailer's books to be added
     * @param books Array that will store Publisher retailer's books
     */
    private void getOnlyBooksFromPublishingRetailer(PublishingRetailer publishingRetailer, MyArrays books){

        if(publishingRetailer == null) return;
        if(publishingRetailer.getPublishingArtifacts().getBooks() == null) return;
        
        for (MyArrayElement element : publishingRetailer.getPublishingArtifacts().getBooks().array) {
            Book book = (Book) element;

            if (!books.containsElement(book))
                books.insertEndElement(book);

        }

    }

    /**
     * Add books from publishingRetailer's PublishingBrand that
     * is not already in array books
     * @param publishingRetailer Publisher retailer's Publishing Brand's books to be added
     * @param books Array that will store Publisher retailer's Publishing Brand's books
     */
    private void getOnlyBooksFromPublishingBrand(PublishingRetailer publishingRetailer, MyArrays books){

        if(publishingRetailer == null) return;
        if(publishingRetailer.getPublishingArtifacts().getPublishingBrands() == null) return;

        for (MyArrayElement element1 : publishingRetailer.getPublishingArtifacts().getPublishingBrands().array) {
            PublishingBrand publishingBrand = (PublishingBrand) element1;
            if(publishingBrand.getBooks() != null) {

                for (MyArrayElement element : publishingBrand.getBooks().array) {
                    Book book = (Book) element;

                    if (!books.containsElement(book))
                        books.insertEndElement(book);


                }
            }
        }

    }

    /**
     * Add books from publishingRetailer's EditorialGroup that
     * is not already in array books
     * @param publishingRetailer Publisher retailer's Editorial Group's books to be added
     * @param books Array that will store Editorial Group's Publishing Brand's books
     */
    private void getOnlyBooksFromEditorialGroup(PublishingRetailer publishingRetailer, MyArrays books){

        if(publishingRetailer == null) return;


        for (MyArrayElement element1 : publishingRetailer.getPublishingArtifacts().getEditorialGroups().array) {
            EditorialGroup editorialGroup = (EditorialGroup) element1;
            if(editorialGroup.getBooks()!= null) {
                for (MyArrayElement element : editorialGroup.getBooks().array) {
                    Book book = (Book) element;

                    if (!books.containsElement(book))
                        books.insertEndElement(book);

                }
            }
        }

    }

    /**
     * Get all books from an publishingRetailer, check also all PublishingBrand
     * and EditorialGroup from publishingRetailer
     * @param publishingRetailerID Publishing Retailer ID where to search
     * @return Array with all books, without repetition
     */
    public MyArrays getBooksForPublishingRetailerID(int publishingRetailerID){

        PublishingRetailer publishingRetailer = (PublishingRetailer) publishingRetailers.findByIdInArr(publishingRetailerID);
        if(publishingRetailer == null) return null;

        MyArrays books = new MyArrays(new Book[0]);

        getOnlyBooksFromPublishingRetailer(publishingRetailer,books);
        getOnlyBooksFromEditorialGroup(publishingRetailer,books);
        getOnlyBooksFromPublishingBrand(publishingRetailer,books);

        return books;

    }

    /**
     * Get all languages from PublishingRetailer's books
     * @param publishingReatilerID Publishing Retailer ID where to search
     * @return Array with all languages, without repetition
     */
    public MyArrays getLanguagesForPublishingRetailerID(int publishingReatilerID){

        MyArrays aux = getBooksForPublishingRetailerID(publishingReatilerID);
        if(aux == null) return  null;

        Book[] books = (Book[]) aux.array;
        if(books == null) return null;

        MyArrays languages = new MyArrays(new Language[0]);

        for (Book book : books) {

            if(!languages.containsElement(book.getLanguage()))
                languages.insertEndElement(book.getLanguage());

        }

        return languages;

    }

    /**
     * Get all country for bookID
     * @param bookID The ID of the book we want to find all countries
     * @return Array with all countries, without repetition
     */
    public MyArrays getCountriesForBookID(int bookID){

        MyArrays countries = new MyArrays(new Countries[0]);
        PublishingRetailer publishingRetailer;

        for (MyArrayElement element : this.publishingRetailers.array) {

            publishingRetailer = (PublishingRetailer) element;
            MyArrays booksFromPublisherRetailer = getBooksForPublishingRetailerID(publishingRetailer.id);
            if(booksFromPublisherRetailer == null)
                continue;

            if(booksFromPublisherRetailer.containsElement(new Book(bookID)))
                for (MyArrayElement element2 : publishingRetailer.getCountries().array) {
                    Countries country = (Countries) element2;

                    if(!countries.containsElement(country))
                        countries.insertEndElement(country);

                }
        }

        return countries;
    }

    /**
     * Get common books for 2 PublishingRetailer
     * @param retailerID1 First Publishing Retailer's ID
     * @param retailerID2 Second Publishing Retailer's ID
     * @return Array with all common books, without repetition
     */
    public MyArrays getCommonBooksForRetailerIDs(int retailerID1, int retailerID2){

        MyArrays books = new MyArrays(new Book[0]);
        MyArrays booksFromPublisher1 = getBooksForPublishingRetailerID(retailerID1);
        MyArrays booksFromPublisher2 = getBooksForPublishingRetailerID(retailerID2);

        if(booksFromPublisher1 == null || booksFromPublisher2==null)
            return null;

        HashSet<MyArrayElement> hs = new HashSet<>();

        for (int i = 0; i < booksFromPublisher1.array.length; i++)
            hs.add(booksFromPublisher1.array[i]);

        for (int i = 0; i < booksFromPublisher2.array.length; i++)
            if (hs.contains(booksFromPublisher2.array[i])) books.insertEndElement(booksFromPublisher2.array[i]);

        return books;

    }

    /**
     * Get all books for 2 PublishingRetailer
     * @param retailerID1 First Publishing Retailer's ID
     * @param retailerID2 Second Publishing Retailer's ID
     * @return Array with all books, without repetition
     */
    public MyArrays getAllBooksForRetailerIDs(int retailerID1, int retailerID2){

        Map<MyArrayElement, Integer> mp = new HashMap<>();

        MyArrays books = new MyArrays(new Book[0]);
        MyArrays booksFromPublisher1 = getBooksForPublishingRetailerID(retailerID1);
        MyArrays booksFromPublisher2 = getBooksForPublishingRetailerID(retailerID2);

        if(booksFromPublisher1 == null || booksFromPublisher2==null)
            return null;

        // Inserting array elements in mp
        for(int i = 0; i < booksFromPublisher1.array.length; i++) {

            mp.put(booksFromPublisher1.array[i], i);

        }

        for(int i = 0; i < booksFromPublisher2.array.length; i++) {

            mp.put(booksFromPublisher2.array[i], i);

        }

        //mp will contain only distinct elements from array a and b
        for(Map.Entry mapElement : mp.entrySet()) {

            books.insertEndElement((Book)mapElement.getKey());

        }

        return books;

    }

}
