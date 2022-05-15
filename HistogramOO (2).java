/**
 * This Object-Oriented" version of the "Histogram" class
 * is intended to test student understanding of when to make fields
 * and methods static or not. 
 */
public class HistogramOO {

    /**
    * This array stores the counts of values for each row (aka "bin") in the histogram.
    * * The first element stores the number of values that are >= 0% and < 10%
    * * The second element stores the number of values that are >=10% and < 20%
    * * etc, etc....
    */
    private int[] bins ;

    public static final int LABEL_WIDTH = 10;

    public HistogramOO() {
        this.bins = new int[10];
    }

    /**
     * Receives a percentage value and updates the histogram accordingly.
     * 
     * If the value is within bounds (i.e. is less than 0 or greater than 100), 
     * then the value of the correspoinding bin should be increased by one. 
     * 
     * If the value is not within bounds, the method should not do anything.
     *
     * @param   value  A  value to be inserted into the histogram
     */ 
    public static void add(double value)
    {
        //add code to this method
        //you should just be able to copy this from last week's histogram exercise
    }

    /**
     * Receives multiple percentage values. Any values that are within bounds are
     * added to the appropriate histogram bin. 
     *
     * @param  values  An array of values to be added to the histogram
     */
    public static void addAll(double... values) {
        //add code to this method
        //you should just be able to copy this from last week's histogram exercise            
    }

    /**
    * Clears the histogram, removing all values that have been added to it.
    */
    public  void reset() {
        //add code to this method
        //you should just be able to copy this from last week's histogram exercise

        for(int i=0; i<bins.length;i++){
            bins[i]=0;
        }
    }

    /**
    * Returns true if the given value is out of bounds 
    * (i.e. less than 0 or greather than 100) or false if not.
    * 
    * @param It needs:
    * - a proper return type (maybe void)
    * - a proper list of parameters (maybe empty)
    * - code to actually do what it should
    */
    public static boolean isOutOfBounds(double value) {
        //add code to this method
        //you should just be able to copy this from last week's histogram exercise            
    }

    /**
    * Returns the index of the bin that the given percentage value belongs to.  
    *
    * For example, it will return:
    *  - 0 when given a percentage value between 0(incl) and 10(excl), 
    *  - 1 when given a percentage value between 10(incl) and 20(excl)
    *  - ...
    * 
    * It assumes it will be given a value that is within bounds. No guarantees are made
    * for how it will behave with values that are out of bounds. 
    */
    public static int getBinIndex(double value) {
        int index = (int) Math.floor(value / 10);

        if (index < 0) index = 0 ;
        if (index > 9) index = 9 ;

        return index ;
    }

    /*
    * Returns a string which, if printed to the console or to the file, provides a rough graphical
    * representation of the histogram. 
    * 
    * This function has been completed for you and does not require any changes
    */
    public  static String renderToString() {

        String rendered = "";

        for (int binIndex=0 ; binIndex<bins.length ; binIndex++) {
            
            rendered = rendered + getLabel(binIndex) ;

            for (int x=0 ; x<bins[binIndex] ; x++) {
                rendered = rendered + "#" ;
            }

            rendered = rendered + "\n" ;
        }

        return rendered ;
    }

    /*
    * Returns a label for the given bin, which shows the minimum and maximum values
    * that the bin represents. 
    */
    public static String getLabel(int binIndex) {
        
        int minValue = binIndex*10 ;
        int maxValue = minValue+10 ;

        String label = minValue + "%-" + maxValue + "%: " ;

        //add padding so the labels line up nicely
        while (label.length() < LABEL_WIDTH) {
            label = " " + label ;
        }

        return label ;
    }
}
