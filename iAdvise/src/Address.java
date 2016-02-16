
import java.io.Serializable;

public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    private String streetNumber;
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address() {
        this("N/A", "N/A", "N/A", "N/A", "N/A");
    }

    public Address(String streetNumber, String street, String city, String state, String zip) {
        this.setStreetNumber(streetNumber);
        this.setStreet(street);
        this.setCity(city);
        this.setState(state);
        this.setZip(zip);
    }

    public Address(Address that) {
        this(that.streetNumber, that.street, that.city, that.state, that.zip);
    }

    //getting the streetnumber
    public String getStreetNumber() {
        return this.streetNumber;
    }

    //getting the street location
    public String getStreet() {
        return this.street;
    }

    //getting the city 
    public String getCity() {
        return this.city;
    }

    //getting the state
    public String getState() {
        return this.state;
    }

    //getting the zipcode
    public String getZip() {
        return this.zip;
    }

    //setting the street number, and if it is not entered the correct way,
    //an error msg will pop up telling the user what was entered wrong
    public void setStreetNumber(String streetNumber) {
        if (!streetNumber.equals("N/A")) {
            for (int i = 0; i < streetNumber.length(); i++) {
                if (!Character.isDigit(streetNumber.charAt(i))) {
                    throw new InvalidException("A street number can only contain digits");
                }
            }
        }
        this.streetNumber = streetNumber;
    }

    //setting the street locations
    public void setStreet(String street) {
        this.street = street;
    }

    //setting the city information up, but if the City contains digits
    //in the city, an error msg will pop up telling the user not to enter digits
    public void setCity(String city) {
        if (!city.equals("N/A")) {
            for (int i = 0; i < city.length(); i++) {
                if ((Character.isDigit(city.charAt(i)))) {
                    throw new InvalidException("A city name can only contain letters");
                }
            }
        }
        this.city = city;
    }

    //setting the state and if the state was to contain digits upon 
    //the users enter, a pop up will come up telling the user that 
    //the state can only contain letters
    public void setState(String state) {
        if (!state.equals("N/A")) {
            for (int i = 0; i < state.length(); i++) {
                if ((Character.isDigit(state.charAt(i)))) {
                    throw new InvalidException("A state name can only contain letters");
                }
            }
        }
        this.state = state;
    }

    //setting the zipcode and if the zip code is more than 5 or less than 5
    //digits, a pop up will come up telling the user to input a 5 digit zip
    //as well as if the user enters in letters, another error will show up
    public void setZip(String zip) {
        if (!zip.equals("N/A")) {
            if (zip.length() != 5) {
                throw new InvalidException("A zip code must be 5 digits in length");
            }

            for (int i = 0; i < zip.length(); i++) {
                if (!Character.isDigit(zip.charAt(i))) {
                    throw new InvalidException("A zip code can only contain digits");
                }
            }
        }
        this.zip = zip;
    }

    //formating the address so it can appear the way you are use to seeing
    //addresses being displayed
    @Override
    public String toString() {
        return String.format("%s %s %s,%s %s",
                this.streetNumber,
                this.street,
                this.city,
                this.state,
                this.zip);
    }

    //splits the fields
    public void Convert(String line) {
        String temp[] = line.split("\\s");
        this.streetNumber = temp[0];
        this.street = temp[1];
        this.city = temp[2];
        this.state = temp[3];
        this.zip = temp[4];
    }
}
