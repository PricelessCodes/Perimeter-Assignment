import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int num = 0;
        for (Point currPt : s.getPoints()) {
            num++;
        }
        return num;
    }

    public double getAverageLength(Shape s) {
        double length = getPerimeter(s);
        
        int num = getNumPoints(s);
        
        return length/num;
    }

    public double getLargestSide(Shape s) {
        double maxSide = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double side = prevPt.distance(currPt);
            if (side > maxSide)
            {
                maxSide = side;
            }    
            prevPt = currPt;
        }
        return maxSide;
    }

    public double getLargestX(Shape s) {
        double maxX = -9999999999.0;
        
        for (Point currPt : s.getPoints()) {
            
            double x = currPt.getX();
            if (x > maxX)
            {
                maxX = x;
            }    
        }
        return maxX;
    }

    public double getLargestPerimeterMultipleFiles() {
        
        double maxLength = 0.0;
        
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            System.out.println("perimeter = " + length);
            
            if (length > maxLength)
            {
                maxLength = length;
            }
        }
        
        return maxLength;
    }

    public String getFileWithLargestPerimeter() {
        double maxLength = 0.0;
        
        File temp = null;  
        
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            
            if (length > maxLength)
            {
                maxLength = length;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        //double length = getPerimeter(s);
        //System.out.println("perimeter = " + length);
        
        //int num = getNumPoints(s);
        //System.out.println("NumPoints = " + num);
        
        //double avg = getAverageLength(s);
        //System.out.println("avg = " + avg);
        
        double maxSide = getLargestSide(s);
        System.out.println("maxSide = " + maxSide);
        
        //double maxX = getLargestX(s);
        //System.out.println("maxX = " + maxX);
    }
    
    public void testPerimeterMultipleFiles() {
        double maxPer = getLargestPerimeterMultipleFiles();
        
        System.out.println("maxPer = " + maxPer);
    }

    public void testFileWithLargestPerimeter() {
        String maxPerFileName = getFileWithLargestPerimeter();
        
        System.out.println("maxPerFileName = " + maxPerFileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
