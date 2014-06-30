
import java.util.*;
import java.lang.*;
import java.io.*;
class Main {

	  static class Point {

	    public int point;
	    public double x;
	    public double y;

	    Point(int a, double b, double c){
		point = a;
		x = b;
		y = c;
		}
	  } 
	  
	  public static List<Point> bestRoute(List<Point> l1) {
		  double x1 = l1.get(0).x;
		  double y1 = l1.get(0).y;
		  l1.remove(0);
						  
		  HashMap<Point,Double> map = new HashMap<Point,Double>();
		  double dist;
		  for(Point ele : l1){
			  dist = Math.pow((ele.x-x1),2) + Math.pow((ele.y-y1),2);
			  map.put(ele, dist);
			}
		  		  		  
		  TreeMap<Point,Double> map1 = sortByValues(map);

		  List<Point> newlist = new ArrayList<Point>(map1.keySet());
		  		  	
		  		  		  
		  return newlist;

		  
	  }
	  
	  public static <Point, Double extends Comparable<Double>> TreeMap<Point, Double> sortByValues(final Map<Point, Double> map) {
		    Comparator<Point> valueComparator =  new Comparator<Point>() {
		        public int compare(Point p1, Point p2) {
		            int compare = map.get(p1).compareTo(map.get(p2));
		            if (compare == 0) return 1;
		            else return compare;
		        }
		    };
		    TreeMap<Point, Double> sortedByValues = new TreeMap<Point, Double>(valueComparator);
		    sortedByValues.putAll(map);
		    return sortedByValues;
		}

	
	
	  public static void main(String[] argv){
		
		  
		  List<Point> l1 = new ArrayList<Point>();

	/*	double[][] locationDetails = { { 1, 37.7768016, -122.4169151}, { 2, 37.7860105, -122.4025377}, 
					    { 3, 37.7821494, -122.4058960}, { 4, 37.7689269, -122.4029053},
					    { 5, 37.7768800, -122.3911496}, { 6, 37.7706628, -122.4040139},
						{ 7, 37.7870361, -122.4039444}, { 8, 37.7507903, -122.3877184},
					    { 9, 37.7914417, -122.3927229}, { 10, 37.8672841, -122.5010216} };
		
			for (double[] entry : locationDetails) {
				l1.add(new Point((int)entry[0], entry[1], entry[2]));
			}  */


		  	if(args.length > 0) {
            			File file = new File(args[0]);
            			FileInputStream fis = null;
            			BufferedReader reader = null;
            		try {
            			fis = new FileInputStream(file);
            			reader = new BufferedReader(new InputStreamReader(fis));
            			String string = reader.readLine();
            			while(string != null){
                		int ind1 = string.indexOf(' |’);
				int ind2 = string.indexOf(‘(’);
				int ind3 = string.indexOf(‘)’);
				int P = Integer.parseInt("string.substring(0, ind1)”);
				String[] data = string.substring(ind2+1, ind3).split(“, ”)
				double x1 = Double.parseDouble(data[0]);
				double y1 = Double.parseDouble(data[1]);
				l1.add(new Point(P, x1, y1));
               		   	 string = reader.readLine();
      			      }           
          
			        } catch (FileNotFoundException e) {
        			    e.printStackTrace();
       				 } catch (IOException ex) {
          			  ex.printStackTrace();
          
        			} finally {
           			 try {
               			 reader.close();
             			   fis.close();
          			  } catch (IOException ex) {
               			 ex.printStackTrace();
            			}
        			}
		
				}

		  while(l1.size()>2){
		  System.out.println(l1.get(0).point);
		  List<Point> list = bestRoute(l1);
		 		l1 = new ArrayList<Point>(list);
		  }
		  System.out.println(l1.get(0).point);
		  System.out.println(l1.get(1).point);

	  }
}





1:37.7768016, -122.4169151
2:37.7860105, -122.4025377
3:37.7821494, -122.405896
4:37.7689269, -122.4029053
5:37.77688, -122.3911496
6:37.7706628, -122.4040139
7:37.7870361, -122.4039444
8:37.7507903, -122.3877184
9:37.7914417, -122.3927229
10:37.8672841, -122.5010216

