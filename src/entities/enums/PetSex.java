package entities.enums;

public enum PetSex {

    MALE("Macho"),
    FEMALE("Femea");

    private String about;

    PetSex(String about) {
        this.about = about;
    }

    public String getAbout() {
        return about;
    }

}
