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
    String max = arrayData[0]; 
    String current = arrayData[1]; 
    for (int i = 1; i < arrayCount; i++)
    {
      current = arrayData[i]; 
      if (current.compareTo(max) >= 0)
        max = current;  
    }
    return max;  
  } 
  
  /** Find the index of the largest string in lexicographical order
    * @return index of max string
    */
  public int getMaxIndex()
  {
    String current = arrayData[0];
    String max = getMax(); 
    for (int i = 0; i < arrayCount; i++)
    { 
      current = arrayData[i]; 
      if (current.equals(max))
        return i;   
    }
    return -1;   
  }
  
  /** Find the min in an integer array in lexicographical order
    * @return min string in array
    */
  public String getMin()
  {
    String min = arrayData[0]; 
    String current = arrayData[1]; 
    for (int i = 1; i < arrayCount; i++)
    {
      current = arrayData[i]; 
      if (current.compareTo(min) <= 0)
        min = current;  
    }
    return min;  
  }
  
  /** Find the index of the smallest number in lexicographical order
    * If there is more than one minimum, it returns the first
    * @return index of min string
    */
  public int getMinIndex()
  {
    String current = arrayData[0];
    String min = getMin(); 
    for (int i = 0; i < arrayCount; i++)
    { 
      current = arrayData[i]; 
      if (current.equals(min))
        return i;   
    }
    return -1; 
  }
  
  /** Find the index of the smallest number in lexicographical order
    * from a given index 
    * @param start index to start searching
    * @return index of min string from a starting position
    */
  public int getMinIndex(int start)
  {
    int pos = start; 
    for (int i = start; i < arrayCount; i++)
    {
      if (arrayData[i].compareTo(arrayData[pos]) < 0)
        pos = i; 
    }
    return pos; 
  }
  
  /** Sorts a string in ascending order 
   */
  public void sort()
  {
    int pos = 0; 
    while (pos < arrayCount - 1)
    {
      int min = getMinIndex(pos); 
      String temp = arrayData[min]; 
      arrayData[min] = arrayData[pos]; 
      arrayData[pos] = temp; 
      pos++; //array is sorted from 0 to position
    }
    printArray(); 
  }

  
  /** Tests the various arra
    * y tools */
  public static void main (String[] args)
  {
    StringArrayTools myArray = new StringArrayTools();
    myArray.fillKeyboard ();
    myArray.printArray ();
    System.out.println ("There are " + myArray.getCount() + " entries in the array.");
    System.out.println ("The largest item (lexicographically) is " + myArray.getMax() ); 
    System.out.println ("The largest item is at index " + myArray.getMaxIndex());
    System.out.println ("The smallest item (lexicographically) is " + myArray.getMin() );
    System.out.println ("The smallest item is at index " + myArray.getMinIndex());
    System.out.println ("The array sorted in ascending order is: "); 
    myArray.sort(); 
    
  }
}
  
  