package entities.enums;

public enum PetSex {

    MALE("Macho"),
    FEMALE("Fêmea");

    private String about;

    PetSex(String about) {
        this.about = about;
    }

    public String getAbout() {
        return about;
    }

}
