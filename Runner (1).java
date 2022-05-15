
/**
 * Provides an entry point for running the code. 
 * 
 * You do not need to alter this class in any way (unless you want to).
 * 
 * @author David Milne
 * @version Feb 2022
 */
public class Runner {

    /*
    * Note: Feel free to change this main method to test different
    * parts of your code and check that it is behaving correctly. 
    *
    * The automatic marking will work regardless of what you do to this method
    * (as long as the code still compiles, obvs.) 
    */
    public static void main(String[] args) throws Exception {

        StudentResult[] allResults = StudentResult.readFile("results.csv");

        //Create histogram that will combine all results together
        HistogramOO combinedHistogram = new HistogramOO();

        //Create histograms for each subject
        String[] subjects = {
            "Programming Fundamentals",
            "Communication for IT Professionals",
            "Introduction to Information Systems"
        };

        HistogramOO[] subjectHistograms = new HistogramOO[3];
        for (int i=0 ; i<subjects.length; i++) {
            subjectHistograms[i] = new HistogramOO();
        }

        //Go through each result, adding it to the appropriate histograms
        for (StudentResult result: allResults) {

            //add result to combined histogram
            combinedHistogram.add(result.getGrade());

            //add result to appropriate subject histogram
            for (int i=0 ; i<subjects.length; i++){

                //if the current result is for the current subject
                if (result.getSubject().equals(subjects[i])) {
                    //add it to the corresponding histogram
                    subjectHistograms[i].add(result.getGrade());
                }
            }
       }
       
       //print subject histograms
       for (int i=0 ; i< subjects.length ; i++) {
           System.out.println("Results for " + subjects[i]);
           System.out.println(subjectHistograms[i].renderToString());
       }

       //print combined histogram
       System.out.println("Results for all subjects (combined)");
       System.out.println(combinedHistogram.renderToString());
    }

}
