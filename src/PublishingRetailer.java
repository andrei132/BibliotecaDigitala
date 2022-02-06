public class PublishingRetailer extends MyArrayElement {

    private String name;
    private final PublishArtefactArray publishingArtifacts;
    private MyArrays countries;

    public PublishingRetailer(Integer id, String name) {

        this.id = id;
        this.name = name;
        this.countries = new MyArrays();
        this.publishingArtifacts = new PublishArtefactArray();

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

    public PublishArtefactArray getPublishingArtifacts() {

        return publishingArtifacts;

    }

    public MyArrays getCountries() {

        return countries;

    }

    public void setCountries(MyArrays countries) {

        this.countries = countries;

    }

}