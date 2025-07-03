// Oscar Hua
// IT CS 142
// Assignment 2
// This program compares two birthdays and displays which one is sooner.
// It calculates how far each birthday is from today and provides a fun fact.

import java.util.*;

public class Birthday_assignment2 {
   
   /**
    * Prints the introduction message explaining the program's purpose.
    */
   public static void intro() {
      System.out.println("This program compares two birthdays and displays which one is sooner.");
   }
   
   /**
    * Asks the user for today's date and converts it to the day of the year.
    * @param input Scanner object for user input
    * @return The current day number in the year (1-366)
    */
   public static int todayDate(Scanner input) {
      System.out.println("What is today's month and day?");
      int Tmonth = input.nextInt();
      int Tday = input.nextInt();
      
      int today = findDayOfYear(Tmonth, Tday);
      System.out.println("Today is " + Tmonth + "/" + Tday + "/2020, day #" + today + " of the year.");
      return today;
   }
   
   /**
    * Returns the number of days in a given month for a leap year (2020).
    * @param month The month (1-12)
    * @return The number of days in the month
    */
   public static int daysInMonth(int month) {
      if (month == 2) return 29; // February in a leap year
      return (month == 4 || month == 6 || month == 9 || month == 11) ? 30 : 31;
   }
   
   /**
    * Converts a given month and day into the day of the year.
    * @param month The month (1-12)
    * @param day The day (1-31)
    * @return The corresponding day of the year (1-366)
    */
   public static int findDayOfYear(int month, int day) {
      int dayOfYear = day;
      for (int i = 1; i < month; i++) {
         dayOfYear += daysInMonth(i);
      }
      return dayOfYear;
   }
   
   /**
    * Gets the birthday input from a user and calculates how far their birthday is from today.
    * @param n Person number (1 or 2)
    * @param today The current day number in the year
    * @param input Scanner object for user input
    * @return The number of days until the next birthday
    */
   public static int person(int n, int today, Scanner input) {
      System.out.println("Person " + n + ":");
      System.out.println("What month and day were you born?");
      int month = input.nextInt();
      int day = input.nextInt();
      
      int days = findDayOfYear(month, day);
      boolean isBirthday = (days == today);
      
      System.out.println(month + "/" + day + "/2020 falls on day #" + days + " of 366.");
      
      if (isBirthday) {
         System.out.println("Happy birthday!");
         return 0; // No days left to birthday
      }
      
      if (days < today) {
         days += 366; // Adjust for next year's birthday
      }
      
      int daysToBirthday = days - today;
      System.out.println("Your next birthday is in " + daysToBirthday + " day(s).");
      System.out.printf("That is %.1f percent of a year away.\n", (double) daysToBirthday / 366 * 100);
      
      return daysToBirthday;
   }
   
   /**
    * Compares two people's birthdays and prints which one is sooner.
    * @param person1 Days until person 1's birthday
    * @param person2 Days until person 2's birthday
    */
   public static void comparison(int person1, int person2) {
      if (person1 < person2) {
         System.out.println("\nPerson 1's birthday is sooner.");
      } else if (person2 < person1) {
         System.out.println("\nPerson 2's birthday is sooner.");
      } else {
         System.out.println("\nWow, you share the same birthday!");
      }
   }
   
   /**
    * Prints a random birthday fact.
    */
   public static void birthdayFact() {
      System.out.println("\nAmerica doesn't have an official national language.");
   }
   
   /**
    * Asks the user if they want to compare more birthdays.
    * @param input Scanner object for user input
    * @return User's choice (1 to continue, 2 to exit)
    */
   public static int askToCompareAgain(Scanner input) {
      System.out.println("\nWould you like to compare two more birthdays?");
      System.out.println("Type 1 to compare two more birthdays or 2 to end the program:");
      return input.nextInt();
   }
   
   /**
    * Prints a closing message and exits the program.
    */
   public static void end() {
      System.out.println("Thank you for using the program. Have a good day!");
   }
   
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int again;
      
      do {
         intro();
         int today = todayDate(input);
         int person1 = person(1, today, input);
         int person2 = person(2, today, input);
         comparison(person1, person2);
         birthdayFact();
         again = askToCompareAgain(input);
      } while (again == 1);
      
      end();
   }
}
