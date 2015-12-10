//Jordan Louie
//APCS1 pd5
//HW45 -- Come Together
//2015-12-09


/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 *  report number of meaningful items
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *  add item (at end)
 *  insert item
 *  remove item (while maintaining "left-justification")
 *****************************/

public class SuperArray {
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() 
    { 
	_data = new Comparable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() 
    {
	String s = "[";
	for (int i = 0; i < _size; i++) {
	    if (i == _size - 1)
		s += _data[i];
	    else 
		s += _data[i] + ",";
	}
	s += "]";
	return s;
	
	/*String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;*/
    }

		
    //double capacity of this SuperArray
    private void expand() 
    { 
	Comparable[] temp = new Comparable[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public Comparable get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) 
    { 
 	Comparable temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) {
	_data[_lastPos+1] = newVal;

	//update vars
	_lastPos++;
	_size++;
    }


    //inserts an item at index
    //shifts existing elements to the right
    public void addAtIndex( int index, Comparable newVal ) {
	//shifts elements to right, starting from right
	for (int i = _lastPos; i >= index; i--){
	    _data[i + 1] = _data[i];
	}
	//adds in newVal
	_data[index] = newVal;

	//update vars
	_lastPos++;
	_size++;
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) {
	//shifts elements to left, each replacing one b4 it, starting from left
	for (int i = index; i < _lastPos; i++)
	    _data[i] = _data[i + 1];

	//update vars
        _lastPos--;
	_size--;
    }


    //return number of meaningful items in _data
    public int size() {
	return _size;
    }

    //-----SuperRepo-----

    //linSearch- returns index of comparable or -1 if not there
    public int linSearch (Comparable c) {
	for (int i = 0; i < _data.length; i++) {
	    if (_data[i] == c)
		return i;
	}
	return -1;
    }

    //isSorted - true if elements sorted least to greatest, else -- false
    public boolean isSorted() {
	for (int i = 0; i < _data.length; i++){
	    if (!(_data[i] < _data[i + 1]))
		return false;
	}
	return true;
    }
    
    //main method for testing
    public static void main( String[] args ) {
	SuperArray mix = new SuperArray();
	mix.add( new Binary(2) );
	mix.add( new Hexadecimal(60) );
	mix.add( new Binary(16) );
	mix.add( new Hexadecimal(100) );
	mix.add( new Rational(2, 1) );
	mix.addAtIndex(3, new Binary(null));

	
    }//end main
		
}//end class
