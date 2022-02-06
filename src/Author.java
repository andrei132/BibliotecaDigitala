public class Author extends MyArrayElement {

    private final String firstName;
    private final String lastName;
    private final MyArrays books;

    public Author(Integer id, String firstName, String lastName, MyArrays books) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;

    }

    public void setId(Integer id) {

        this.id = id;

    }

    public String getFirstName() {

        return firstName;

    }

    public String getLastName() {

        return lastName;

    }

    public MyArrays getBooks() {

        return books;

    }

}
