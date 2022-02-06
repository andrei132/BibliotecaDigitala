public class EditorialGroup extends MyArrayElement implements IPublishingArtifact{

    private String name;
    private MyArrays books;

    public EditorialGroup(Integer id, String name, MyArrays books) {

        this.id = id;
        this.name = name;
        this.books = books;

    }

    public void setId(Integer id) {

        this.id = id;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public MyArrays getBooks() {

        return books;

    }

    public void setBooks(MyArrays books) {

        this.books = books;

    }

    @Override
    public String publish() {

        final StringBuffer sb = new StringBuffer("<xml>\n");

        sb.append("\t<editorialGroup>\n");
        sb.append("\t\t<ID>").append(this.id).append("</ID>\n");
        sb.append("\t\t<Name>").append(this.name).append("</Name>\n");
        sb.append("\t</editorialGroup>\n");
        sb.append("\t<Books>\n");

        for (MyArrayElement element : this.books.array) {

            Book book = (Book) element;

            sb.append("\t\t<Book>\n");
            sb.append(book.bookInfo(3));
            sb.append("\t\t</Book>\n");

        }

        sb.append("\t</Books>\n");
        sb.append("</xml>");

        return sb.toString();

    }

}
