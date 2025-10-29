/*
Given a sorted linked list, delete all nodes that have duplicate
numbers, leaving only distinct numbers from the original list.In this 
program, you need to 
(1) read 5 numbers and set them in a linkedlist in order
(2) delete duplicate

Example 1:
input: 1,2,3,3,5
output: head-->1-->2-->3-->5-->null

Example 2:
input: 1,1,1,2,3
output: head-->1-->2-->3-->null

Please complete the following program to fullfil the function.
*/
import java.util.*;

public class homework20_1
{
   public static void main(String[] args)
   {
      //add your code here
      Scanner input = new Scanner(System.in);   //User enters numbers
      LinkedList llist = new LinkedList();    //New empty list to hold five integers
      
      System.out.println("Enter five integers, sorted:");
      for (int i = 0; i < 5; i++)   //Reads and stores integers at the end of linkedlist llist
      {
         int n = input.nextInt();
         llist.append(n);
      }
      
      deleteDuplicates(llist);    //Method call
      System.out.println(llist);  //Prints linkedlist llist
      
      input.close();    //Close scanner
   }
   
   public static void deleteDuplicates(LinkedList llist)
   {
      //add your code here
      ListNode curr = llist.head;   //Pointer for head of linkedlist
      while (curr != null && curr.next != null)    //Continues through end of llist
      {
         if (curr.value == curr.next.value)  //Checks if current node and the next are duplicate
         {
            curr.next = curr.next.next;   //Skips duplicate
         }
         else
         {
            curr = curr.next;    //If unique, move to next node
         }
      }
   }
}

class ListNode
{
   int value;
   ListNode next;
   ListNode(int v){value = v;}
}

class LinkedList
{
   ListNode head;
   
   /**
   *  append() adds new node to end of linked list llist
   *  @param
   */
   public void append(int value)
   {
      if (head == null)    //Checks for empty head
      {
         head = new ListNode(value);   //Creates new node and sets node as head
      }
      
      else
      {
         ListNode curr = head;   //Pointer
         while (curr.next != null)     //Cycles through to last node
         {
            curr = curr.next;
         }
         curr.next = new ListNode(value);    //Creates new node from value and stores at end of linked list llist
      }
   }
   
   public String toString()
   {
      String nodeData = "";
      ListNode ref = head;
      while(ref != null)
      {
         nodeData += ref.value + "-->";
         ref = ref.next;
      }
      return "head-->"+nodeData+"null";
   }
}