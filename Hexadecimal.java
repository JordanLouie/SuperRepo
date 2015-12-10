//Team VT - Jordan Louie and Kevin Hwang
//APCS1 pd5
//HW44 -- This or That or Fourteen Other Things
//2015-12-08

public class Hexadecimal implements Comparable{
    
    private final static String HEXDIGITS = "0123456789ABCDEF"; 
    private int _decNum;
    private String _hexNum;
    
    
    public Hexadecimal() {
        _decNum = 0;
        _hexNum = "0";
    }
    
    public Hexadecimal(int n) {
        _decNum = n;
        _hexNum = decToHex(n);
    }
    
    public Hexadecimal(String s) {
        _decNum = hexToDec(s);
        _hexNum = s;
    }
    
    public String toString() {
        return _hexNum;
    }
    
    public static String decToHex (int n) {
        String ret = "";
        if(n<16) return HEXDIGITS.substring(n,n+1);
        while ( n >= 16 ) {
            ret = HEXDIGITS.substring(n%16, n%16 + 1) + ret;
            n /= 16; }
        return "1"+ret;
    }
    
    public static String decToHexR (int n) {
        if(n<16) return "1";
	    else return decToHexR(n/16) + HEXDIGITS.indexOf(""+n%16); 
    }
    
    public static int hexToDec (String s) {
        int ret = 0;
        int dex = s.length();
        for( ; dex>0 ; dex--) ret+=Math.pow(16, dex-1) * HEXDIGITS.indexOf(s.substring(s.length()-dex, s.length()-dex+1)) ;
        return ret;
    }
    
    public static int hexToDecR (String s) {
        if(s.length()==1) return HEXDIGITS.indexOf(s);
	    else return hexToDecR( s.substring(1) ) + HEXDIGITS.indexOf(s.substring(0,1)) * (int)Math.pow(16, s.length() - 1);
    }
    
    public static int hexToDecR2 (String s) {
        int dex = s.length();
        int ret = Integer.parseInt(s.substring(0,1));
        for (int x = 1 ; x < dex ; x++) ret = ret * 16 + HEXDIGITS.indexOf(s.substring(x,x+1));
        return ret;
    }
    
    public boolean equals( Object other ) { 
    	return _hexNum.equals(((Hexadecimal)other)._hexNum);  
    }
    
   
    public int compareTo( Object other ) {
	if (other == null)
	    throw new NullPointerException("Error: null");
	if (!(other instance of Comparable))
	    throw new ClassCastException("Error: not a Comparable");
    	else
	    return this._decNum - ((Hexadecimal)other)._decNum;
    }
    
    //main method for testing
    public static void main( String[] args ) {

	System.out.println();
	System.out.println( "Testing ..." );

	Hexadecimal h1 = new Hexadecimal(12);
	Hexadecimal h2 = new Hexadecimal(12);
	Hexadecimal h3 = h1;
	Hexadecimal h4 = new Hexadecimal(20);
	Hexadecimal h5 = new Hexadecimal("E");
	Hexadecimal h6 = new Hexadecimal("1A");

	System.out.println( h1 ); 
	System.out.println( h2 );
	System.out.println( h3 );       
	System.out.println( h4 );
	System.out.println( h5 );
	System.out.println( h6 ); 

	System.out.println( "\n==..." );
	System.out.println( h1 == h2 ); //should be false
	System.out.println( h1 == h3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( h1.equals(h2) ); //should be true
	System.out.println( h1.equals(h3) ); //should be true
	System.out.println( h3.equals(h1) ); //should be true
	System.out.println( h4.equals(h2) ); //should be false
	System.out.println( h1.equals(h4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( h1.compareTo(h2) ); //should be 0
	System.out.println( h1.compareTo(h3) ); //should be 0
	System.out.println( h1.compareTo(h4) ); //should be -8
	System.out.println( h4.compareTo(h1) ); //should be 8
	System.out.println( h4.compareTo(h5) ); //should be 6
	System.out.println( h4.compareTo(h6) ); //should be -6
    }
}
