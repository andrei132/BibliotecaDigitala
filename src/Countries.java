public class Countries extends MyArrayElement {

    private String countryCode;

    public Countries(Integer id, String countryCode) {

        this.id = id;
        this.countryCode = countryCode;

    }

    public void setId(Integer id) {

        this.id = id;

    }

    public String getCountryCode() {

        return countryCode;

    }

}
