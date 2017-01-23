/** The class StringArrayTools implements a variety of basic array tasks
  * using an array of strings.
  * 
  * The array has a fixed length MAX_NUMS but the actual number of elements
  * that are used can vary.
  * 
  * All mmethods that only work with IntegerArrayTools have been removed for clarity
  * 
  * Modified by Alison Xin on 2017.01.18
  */

import java.util.Scanner;

public class StringArrayTools
{
  private String[] arrayData;
  private int arrayCount;
  public final int MAX_NUMS = 100;
  
  // ------------------ CONSTRUCTOR ----------------------------
  /** The contsructor merely creates the array.
    * It does not fill it with any data.  That is left up to 
    * fillKeyboard method.
    */
  public StringArrayTools ()
  {
    arrayData = new String[MAX_NUMS];
    arrayCount = 0;
  }
  
  /** Returns the number of objects in the array.
    * @return the count of items in the array. */
  public int getCount ()
  {
    return arrayCount;
  }
  
  // ------------------- METHODS TO FILL THE ARRAY -------------------------
  /** Adds an element to the end of the array. 
    * @param n The element to add
    * @return whether the element was successfully added
    */
  public boolean addItem (String n)
  {
    if (arrayCount < MAX_NUMS)
    {
      arrayData[arrayCount] = n;
      arrayCount++;
      return true;
    }
    else
      return false;
  }
 
  
  /** Fills the array with Strings entered by the user
    * @param myArray the array to fill.  Returns a modified array.
    */
  public void fillKeyboard ()
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println ("Please enter strings on one line, separated enter");
    System.out.println ("Use a blank string to signal the end of the list.");
    
    arrayCount = 0;
    String enter = keyboard.nextLine();
    while (enter.length() != 0)                 // stop input when user enters -1
    {
      addItem(enter);
      enter = keyboard.nextLine();
    }
    keyboard.close();
  }
  
  // -------------------- METHODS TO WORK WITH THE ARRAY --------------------------
  /** Prints the array, new line for each string.
    */
  public void printArray ()
  {
    for (int i = 0; i < arrayCount; i++)
    {
      System.out.print (arrayData[i] + "  ");
      System.out.println(); 
    }
    System.out.println();
  }
  
  
  /** Find the max in an String array in lexicographical order
    * @return max string in array
    */
  public String getMax()
  {
    String prev = arrayData[0];
    String max = arrayData[0]; 
    for (int i = 1; i < arrayCount; i++)
    {
      String current = arrayData[i]; 
      int result = current.compareTo(prev); 
      if (result >= 0)
        max = current; 
      
      prev = arrayData[i]; 
    }
    return max; 
  }
  
  /** Find the index of the largest string in lexicographical order
    * @return index of max string
    */
  public int getMaxIndex()
  {
    String prev = arrayData[0];
    int max = 0; 
    for (int i = 1; i < arrayCount; i++)
    {
      String current = arrayData[i]; 
      int result = current.compareTo(prev); 
      if (result >= 0)
        max = i; 
      
      prev = arrayData[i]; 
    }
    return max; 
  }
  
  /** Find the min in an integer array in lexicographical order
    * @return min string in array
    */
  public String getMin()
  {
    String prev = arrayData[0];
    String min = arrayData[0]; 
    for (int i = 1; i < arrayCount; i++)
    {
      String current = arrayData[i]; 
      int result = current.compareTo(prev); 
      if (result <= 0)
        min = current; 
      
      prev = arrayData[i]; 
    }
    return min;  
  }
  
  /** Find the index of the smallest number in lexicographical order
    * @return index of min string
    */
  public int getMinIndex()
  {
    String prev = arrayData[0];
    int min = 0; 
    for (int i = 1; i < arrayCount; i++)
    {
      String current = arrayData[i]; 
      int result = current.compareTo(prev); 
      if (result <= 0)
        min =  i; 
      
      prev = arrayData[i]; 
    }
    return min;  
  }
 
  
  /** Tests the various arra
    * y tools */
  public static void main (String[] args)
  {
    StringArrayTools myArray = new StringArrayTools();
    myArray.fillKeyboard ();
    myArray.printArray ();
    System.out.papplerintln ("There are " + myArray.getCount() + " entries in the array.");
    System.out.println ("The largest item (lexicographically) is " + myArray.getMax() ); 
    System.out.println ("The largest item is at index " + myArray.getMaxIndex());
    System.out.println ("The smallest item (lexicographically) is " + myArray.getMin() );
    System.out.println ("The smallest item is at index " + myArray.getMinIndex());
    
  }
}
  
  