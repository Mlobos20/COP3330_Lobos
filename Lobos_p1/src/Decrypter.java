public class Decrypter {
// variables to hold digits derived from inputted string
int firstDigit;
int secondDigit;
int thirdDigit;
int fourthDigit;

// variables to hold strings to compose into a message
String firstChar;
String secondChar;
String thirdChar;
String fourthChar;

    public String decrypt(String ciphertext){
        String plainttext; // variable to hold the completed encrypted text
        digitAssign(ciphertext); // breaking up the inputted string into separate variables

        // the actual math that changes the value of the digit
        this.firstDigit = (this.firstDigit + 3) % 10;
        this.secondDigit = (this.secondDigit + 3) % 10;
        this.thirdDigit = (this.thirdDigit + 3) % 10;
        this.fourthDigit = (this.fourthDigit + 3) % 10;

        charAssign(); // turning the digits into a string to be composed

        plainttext = compose(); // arranging and composing the message

        return plainttext; // returning the decrypted message
    }

    public void digitAssign(String plaintext){ // This function converts the ASCII value to a digit value 0-9
        this.firstDigit = plaintext.charAt(0) - 48;
        this.secondDigit = plaintext.charAt(1) - 48;
        this.thirdDigit = plaintext.charAt(2) - 48;
        this.fourthDigit = plaintext.charAt(3) - 48;
    }

    public void charAssign(){ // This function converts the digit value into a string
        firstChar = Integer.toString(this.firstDigit); // uses toString operator to turn int into string for message composition
        secondChar = Integer.toString(this.secondDigit);
        thirdChar = Integer.toString(this.thirdDigit);
        fourthChar = Integer.toString(this.fourthDigit);
    }

    public String compose(){ // This function composes the message by concatenating all of the individual strings
        String composedMsg;

        composedMsg = (this.thirdChar + this.fourthChar + this.firstChar + this.secondChar); // creates string with predetermined positioning

        return composedMsg;
    }
}
