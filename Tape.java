package turing;
/**
* A Turing machine is controlled by a "tape" that serves as both input and output.
* The tape is made up of little squares called cells that are arranged in a
* horizontal row that spans in both directions to infinity. A single character can
* be stored in each cell. A cell's content starts out as a blank space. The present
* cell on the tape is regarded to be one of the cells on the tape. This is the
* location of the machine's cell. The current cell of a Turing machine changes as
* it goes back and forth down the tape.
* Turing machine tapes are represented by the Tape class.
*/
public class Tape {
private Cell currentCell;
/**
* A constructor that starts with a single cell and generates a tape from there.
* The current cell pointer should point to the blank space in the cell.
*/
public Tape() {
Cell cellContent = new Cell();
cellContent.content = ' ';
cellContent.prev = null;
cellContent.next = null;
currentCell = cellContent;
}
/**
* The pointer that points to the current cell is returned.
* @return currentCell
*/
public Cell getCurrentCell() {
return currentCell;
}
/**
* The current cell's char is returned.
* @return currentCell.content
*/
public char getContent() {
return currentCell.content;
}
/**
* The current cell's char is changed to the provided value.
* @param ch
*/
public void setContent(char ch) {
currentCell.content = ch;
}
/**
* Moves the current cell along the tape one position to the left.
* If the current cell is the leftmost cell on the tape, a new cell must
* be generated and placed to the tape to the left of the current cell,
* and the current cell pointer can then be moved to point to the new cell.
* The new cell's content should be a blank space.
*/
public void moveLeft() {
if (currentCell.prev == null) {
Cell cellContent = new Cell();
cellContent.content = ' ';
cellContent.prev = null;
cellContent.next = currentCell;
currentCell.prev = cellContent;
}
currentCell = currentCell.prev;
}
/**
* Moves the current cell along the tape one position to the right.
* If the current cell is the rightmost cell on the tape, a new cell must be
* generated and placed to the tape to the right of the current cell, and then
* the current cell pointer can be moved to point to the new cell. The new
* cell's content should be a blank space.
*/
public void moveRight() {
if (currentCell.next == null) {
Cell cellContent = new Cell();
cellContent.content = ' ';
cellContent.prev = currentCell;
cellContent.next = null;
currentCell.next = cellContent;
}
currentCell = currentCell.next;
}
/**
* Returns a String containing the characters from all of the tape's cells, read
* from left to right, with leading and trailing blank characters deleted.
* This method should not move the current cell pointer; it should point to the
* same cell as previously when the method is called. You can use a different
* cursor to navigate the tape and receive the entire contents.
* @return content
*/
public String getTapeContents() {
Cell point = currentCell;
while (point.prev != null) {
point = point.prev;
}
String content = "";
while (point != null) {
content += point.content;
point = point.next;
}
content = content.trim();
return content;
}
}