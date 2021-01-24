/**
 * 
 */
package somedatamodel;

/**
 * Class description - THIS IS JUST AN EXAMPLE MODEL
 * 
 * @author Samuel
 *
 */
public class SomeDataClass {
	
	private String[] someArray;
	private String someString;
	
	public SomeDataClass() {

		someArray = new String[10];
		someArray[0] = "Placeholder 1";
		someArray[1] = "Placeholder 2";
		someArray[2] = "Placeholder 3";
		someArray[3] = "Placeholder 4";
		someArray[4] = "Placeholder 5";
		someArray[5] = "Placeholder 6";
		someArray[6] = "Placeholder 7";
		someArray[7] = "Placeholder 8";
		someArray[8] = "Placeholder 9";
		someArray[9] = "Placeholder 10";
		someString = "SEG";
		
	}
	
	public String[] getSomeArray() {
		
		return someArray;
	
	}
	
	public String getSomeString() {
		
		return someString;
		
	}
	
	public void doStuffData() {
		
	}
}
