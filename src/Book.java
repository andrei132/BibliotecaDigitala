import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Book extends MyArrayElement implements IPublishingArtifact{

    private String name;
    private String subtitle;
    private String isbn;
    private Integer pageCount;
    private String[] keyword;
    private Language language;
    private Calendar createdON;
    private MyArrays authors;

    public Book(Integer id, String name, String subtitle, String isbn, Integer pageCount, String[] keyword,
                Language language, String createdON, MyArrays authors) {

        this.id = id;
        this.name = name;
        this.subtitle = subtitle;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.keyword = keyword;
        this.language = language;
        this.createdON = stringToCalendar(createdON);
        this.authors = authors;

    }

    public Book(Integer id){

        this.id = id;

    }

    public MyArrays getAuthors() {

        return this.authors;

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

    public String getSubtitle() {

        return subtitle;

    }

    public void setSubtitle(String subtitle) {

        this.subtitle = subtitle;

    }

    public String getIsbn() {

        return isbn;

    }

    public void setIsbn(String isbn) {

        this.isbn = isbn;

    }

    public Integer getPageCount() {

        return pageCount;

    }

    public void setPageCount(Integer pageCount) {

        this.pageCount = pageCount;

    }

    public String[] getKeyword() {

        return keyword;

    }

    public Language getLanguage() {

        return language;

    }

    public void setLanguage(Language language) {

        this.language = language;

    }

    public String getCreatedON() {

        return calendarToString(createdON);

    }

    public void setCreatedON(String createdON) {

        this.createdON = stringToCalendar(createdON);

    }

    /**
     * Convert from string to calendar
     * @param data String with data in format dd.MM.yyyy HH:mm:ss
     * @return Calendar var
     */
    private Calendar stringToCalendar(String data){

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        try {
            cal.setTime(sdf.parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return cal;

    }

    /**
     * Convert from Calendar to string
     * @param cal Calendar var
     * @return String with data in format dd.MM.yyyy HH:mm:ss
     */
    private String calendarToString(Calendar cal){

        if(cal == null) return null;
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        return format.format(cal.getTime());

    }

    /**
     * Create a string with all info about book with tabs
     * @param nrTabs Number of tabs
     * @return String with info
     */
    public String bookInfo(int nrTabs){

        final StringBuffer sb = new StringBuffer();
        final StringBuffer tab = new StringBuffer();

        tab.append("\t".repeat(Math.max(0, nrTabs)));

        sb.append(tab).append("<title>").append(this.name).append("</title>\n");
        sb.append(tab).append("<subtitle>").append(this.subtitle).append("</subtitle>\n");
        sb.append(tab).append("<isbn>").append(this.isbn).append("</isbn>\n");
        sb.append(tab).append("<pageCount>").append(this.pageCount).append("</pageCount>\n");
        sb.append(tab).append("<keywords>");

        for (String s : this.getKeyword()) {

            sb.append(s).append(" ");

        }

        sb.append("</keywords>\n");
        sb.append(tab).append("<languageID>").append(this.language.getId()).append("</languageID>\n");
        sb.append(tab).append("<createdOn>").append(this.getCreatedON()).append("</createdOn>\n");

        sb.append(tab).append("<authors>");

        for (MyArrayElement element : this.authors.array) {

            Author author = (Author) element;
            sb.append("[").append(author.getFirstName()).append(" ").append(author.getLastName()).append("]");

        }
        sb.append("</authors>\n");

        return sb.toString();

    }

    @Override
    public String publish() {

        final StringBuffer sb = new StringBuffer("<xml>\n");

        sb.append(this.bookInfo(1));
        sb.append("</xml>");

        return sb.toString();

    }

}
