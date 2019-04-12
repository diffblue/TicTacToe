package com.diffblue.javademo;

public class Limitations {

  /**
   * A method with dead code inside.
   */
  public boolean deadCode(int number, String someString) {
    if (number > 5) {
      return true;
    }
    if (number > 10) {
      // This is dead code and therefore cannot be reached.
      for (int count = 0; count < number; count++) {
        System.out.println("inside the loop");

        //Sort string alphabetically
        char[] chars = someString.toCharArray();
        boolean changed;
        do {
          changed = false;
          for (count = 0; count < someString.length() - 1; count++) {
            System.out.println("DEBUG: Current character is: " + chars[count]);
            if (chars[count] > chars[count + 1]) {
              char temp = chars[count];
              chars[count] = chars[count + 1];
              chars[count + 1] = temp;
              changed = true;
              System.out.println("DEBUG: We changed something");
            }
          }
        } while (changed);
      }
      System.out.println("This cannot be reached, you will never see this message");
      return true;
    }
    return false;
  }

  /**
   * Some code that is very complex to analyze.
   */
  public boolean isHash(String someString) {
    if (someString.hashCode() ==  1167583247) {
      // To cover this code you need to work out a string that will hash to 1167583247

      String backwardsString = new String();

      System.out.println("DEBUG: Input string is" + someString);
      for (int count = someString.length(); count > 0; count--) {
        String currentChar = someString.substring(count, count + 1);
        System.out.println("DEBUG: Current character is: " + currentChar);
        backwardsString = backwardsString.concat(currentChar);
        System.out.println("DEBUG: Current backwards string is: " + backwardsString);
      }
      System.out.println("To get here you need to reverse engineer a real string from the hash");
      System.out.println("Your string backwards is: " + backwardsString);
      return true;
    }
    return false;
  }

  /**
   * Some code using a feature not fully supported by cover.
   */
  public boolean compareWithLambda(int number, int anotherNumber) {

    System.out.println("This line will not be covered");
    MyCompare myCompare = (num1, num2) ->
    {
      return num1 > num2;
    };
    System.out.println("This includes a lambda which we do not fully support");
    System.out.println("This line will not be covered.");
    return myCompare.compare(number, anotherNumber);
  }
}
