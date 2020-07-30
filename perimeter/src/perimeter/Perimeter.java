/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perimeter;
import edu.duke.*;
import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeMap;
/**
 *
 * @author edanP
 */
public class Perimeter {              
    
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
        // Put code here
        int response = 0;
        for (Point object : s.getPoints()) {
            response++;
        }
        return response;
    }

    public double getAverageLength(Shape s) {
        return getPerimeter(s) / getNumPoints(s);      
    }

    public double getLargestSide(Shape s) {
        LinkedList<Double> sides = new LinkedList<>(); 
                   
        Point prevPt = s.getLastPoint();
        
        for (Point currPt : s.getPoints()) {            
            double currDist = prevPt.distance(currPt);                                               
            sides.add(currDist);
            prevPt = currPt;
        }        
        
        Collections.sort(sides);
        
        return sides.getLast();
    }

    public double getLargestX(Shape s) {
        LinkedList<Integer> points = new LinkedList<>(); 
        for (Point currPt : s.getPoints()) {            
            points.add(currPt.getX());
        }        
        
        Collections.sort(points);
        return points.getLast();
    }

    public double getLargestPerimeterMultipleFiles() {
        LinkedList<Double> shapes = new LinkedList<>();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);            
            shapes.add(getPerimeter(new Shape(fr)));
        }        
        Collections.sort(shapes);
        return shapes.getLast();
    }

    public String getFileWithLargestPerimeter() {
        TreeMap<Integer, File> test = new TreeMap<Integer, File>();        
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);        
            test.put((int)getPerimeter(new Shape(fr)), f);
        }                 
        return test.lastEntry().getValue().toString();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);       
              
        System.out.println("perimeter = " + getPerimeter(s));
        System.out.println("number of points= " + getNumPoints(s));
        System.out.println("average length= " + getAverageLength(s));   
        System.out.println("largest side= " + getLargestSide(s));
        System.out.println("largest x= " + getLargestX(s));
    }
    
    public void testPerimeterMultipleFiles() {
        System.out.println("the largest perimeter from multiple files= " + getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        System.out.println("the file with the largest perimeter= " + getFileWithLargestPerimeter());
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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Perimeter pr = new Perimeter();
        //pr.testPerimeter();
        //pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
    
}
