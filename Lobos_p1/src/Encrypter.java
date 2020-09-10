public class Encrypter {
int firstDigit;
int secondDigit;
int thirdDigit;
int fourthDigit;

String firstChar;
String secondChar;
String thirdChar;
String fourthChar;

    public String encrypt(String plaintext){
        String ciphertext;
        digitAssign(plaintext);

        this.firstDigit = (this.firstDigit + 7) % 10;
        this.secondDigit = (this.secondDigit + 7) % 10;
        this.thirdDigit = (this.thirdDigit + 7) % 10;
        this.fourthDigit = (this.fourthDigit + 7) % 10;

        charAssign();

        ciphertext = compose();

        return ciphertext;
    }

    public void digitAssign(String plaintext){
        this.firstDigit = plaintext.charAt(0) - 48;
        this.secondDigit = plaintext.charAt(1) - 48;
        this.thirdDigit = plaintext.charAt(2) - 48;
        this.fourthDigit = plaintext.charAt(3) - 48;
    }

    public void charAssign(){
        firstChar = Integer.toString(this.firstDigit);
        secondChar = Integer.toString(this.secondDigit);
        thirdChar = Integer.toString(this.thirdDigit);
        fourthChar = Integer.toString(this.fourthDigit);
    }

    public String compose(){
        String composedMsg;

        composedMsg = (this.thirdChar + this.fourthChar + this.firstChar + this.secondChar);

        return composedMsg;
    }

}
