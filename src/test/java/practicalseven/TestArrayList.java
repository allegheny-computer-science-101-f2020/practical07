package practicalseven;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import practicalseven.list.ArrayList;
import practicalseven.list.SinglyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A JUnit test suite for the ArrayList.
 *
 * @author Janyl Jumadinova
 * @author Add Your Name Here
 */

public class TestArrayList {

  /** The size of the ArrayList with multiple values. */
  private static final int SIZE = 10;

  @Test
  public void testConstructArrayListNotNull() {
    ArrayList<String> list = new ArrayList<String>();
    assertTrue(list != null);
  }

  @Test
  public void testConstructArrayListCorrectInitialState() {
    ArrayList<String> list = new ArrayList<String>();
    assertEquals(list.getSize(), 0);
    assertTrue(list.isEmpty());
  }

  // TODO: test Construct ArrayList InitialState

  // TODO: test IndexOutOfBoundsException

  // TODO: test correct size after `add`

  @Test
  public void testToStringDoesNotReturnNull() {
    ArrayList<String> list = new ArrayList<String>();
    list.add(0, new String("First"));
    list.add(1, new String("Last"));
    String textualRepresentation = list.toString();
    assertTrue(textualRepresentation != null);
    assertTrue(textualRepresentation.contains(","));
    assertTrue(textualRepresentation.contains("("));
    assertTrue(textualRepresentation.contains(")"));
  }

  @Test
  public void testNotEqualsForNullValue() {
    ArrayList<String> listOne = new ArrayList<String>();
    listOne.add(0, new String("Element One"));
    listOne.add(1, new String("Element Two"));
    assertTrue(!listOne.equals(null));
  }

  @Test
  public void testNotEqualsForDifferentDataType() {
    ArrayList<String> listOne = new ArrayList<String>();
    listOne.add(0, new String("Element One"));
    listOne.add(1, new String("Element Two"));
    SinglyLinkedList<String> listTwo = new SinglyLinkedList<String>();
    listTwo.addLast(new String("Element One"));
    listTwo.addLast(new String("Element Two"));
    assertTrue(!listOne.equals(listTwo));
    assertTrue(!listTwo.equals(listOne));
  }

  @Test
  public void testEqualsForSameData() {
    ArrayList<String> listOne = new ArrayList<String>();
    listOne.add(0, new String("Element One"));
    listOne.add(1, new String("Element Two"));
    ArrayList<String> listTwo = new ArrayList<String>();
    listTwo.add(0, new String("Element One"));
    listTwo.add(1, new String("Element Two"));
    assertTrue(listOne.equals(listTwo));
    assertTrue(listTwo.equals(listOne));
  }

  @Test
  public void testNotEqualsForDifferentData() {
    ArrayList<String> listOne = new ArrayList<String>();
    listOne.add(0, new String("Element One"));
    listOne.add(1, new String("Element Two"));
    ArrayList<String> listTwo = new ArrayList<String>();
    listTwo.add(0, new String("Element One"));
    listTwo.add(1, new String("Element Two Different!"));
    assertTrue(!listOne.equals(listTwo));
    assertTrue(!listTwo.equals(listOne));
  }

  @Test
  public void testAddAndRemoveManyStringsToArrayListWithAdd() {
    ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < SIZE; i++) {
      list.add(i, Integer.toString(i));
    }
    assertTrue(!list.isEmpty());
    assertEquals(list.getSize(), SIZE);
    for (int i = 0; i < SIZE; i++) {
      list.remove(0);
    }
    assertTrue(list.isEmpty());
    assertEquals(list.getSize(), 0);
  }

  @Test
  public void testAddStringsAndThenRemoveWithIterator() {
    ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < SIZE; i++) {
      list.add(i, Integer.toString(i));
    }
    assertTrue(!list.isEmpty());
    assertEquals(list.getSize(), SIZE);
    Iterator<String> iterator = list.iterator();
    assertTrue(iterator != null);
    assertTrue(iterator.hasNext());
    for (int i = 0; i < SIZE; i++) {
      assertTrue(iterator.next() != null);
    }
    assertTrue(!iterator.hasNext());
  }

  @Test(expected = NoSuchElementException.class)
  public void testAddStringsAndThenRemoveWithIteratorThrowsException() {
    ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < SIZE; i++) {
      list.add(i, Integer.toString(i));
    }
    assertTrue(!list.isEmpty());
    assertEquals(list.getSize(), SIZE);
    Iterator<String> iterator = list.iterator();
    assertTrue(iterator != null);
    assertTrue(iterator.hasNext());
    for (int i = 0; i < SIZE; i++) {
      assertTrue(iterator.next() != null);
    }
    assertTrue(!iterator.hasNext());
    iterator.next();
  }

}
