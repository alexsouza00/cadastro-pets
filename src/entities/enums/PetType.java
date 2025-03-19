package entities.enums;

public enum PetType {
   CAT("Gato"), DOG("Cachorro");

   private String about;

   PetType(String about) {
      this.about = about;
   }

   public String getAbout() {
      return about;
   }

}
