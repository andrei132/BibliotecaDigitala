public class Language extends MyArrayElement {

    private String code;
    private String name;

    public Language(Integer id, String code, String name) {

        this.id = id;
        this.code = code;
        this.name = name;

    }

    public void setId(Integer id) {

        this.id = id;

    }

    public String getCode() {

        return code;

    }

    public void setCode(String code) {

        this.code = code;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

}
