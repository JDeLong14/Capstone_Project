
public class Zip {

	String zipCode;

        //gathering up the information on the zipCode. 
        //if the zip code is greater than 5 digits or less 
        //than 5, a msg will pop up telin you tht you entered 
        public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {

		if(zipCode.length()>5 ||zipCode.length()<5 )
			throw new InvalidException("Incorrect Zip Code");
		for(int i=0;i<zipCode.length();i++)
		{
			if(Character.isWhitespace(zipCode.charAt(i)) || Character.isLetter(zipCode.charAt(i)) )
				throw new InvalidException("Incorrect Zip Code");
		}
		this.zipCode = zipCode;
	}

	public Zip()
	{
		zipCode="";
	}



}
