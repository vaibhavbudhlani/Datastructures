public class FindSqrtVB {
  /*
  *   double squareRoot( double x )
  *
  */

//    double number = 25; // Change this number to calculate the square root
//
//    double epsilon = 0.00001; // Defines the precision of the result
//    double low = 0;
//    double high = number;
//    double guess = (low + high) / 2.0;
//
//        while (high - low > epsilon) {
//        if (guess * guess < number) {
//            low = guess;
//        } else {
//            high = guess;
//        }
//        guess = (low + high) / 2.0;
//    }

	private static double findSqrt(double x, double min, double max) {
		double mid = (max + min) / 2;
		double midsq = mid*mid;
		if(midsq < x + 0.001 && midsq > x - 0.001) {
			return mid;
		}
		else if( midsq > x + 0.001) {
			return findSqrt(x, min, mid);
		}
		else {
			return findSqrt(x, mid, max);	
		}

	}

    private static double squareRoot1(double number)
    {
//iterator variable
        int i = 1;
        while(true)
        {
//for perfect square numbers
            if(i*i == number)
                return i;
//for not perfect square numbers
            else if(i*i > number)
//returns the value calculated by the method decimalSqrt()
                return decimalSqrt(number,i-1,i);
//increments the variable i by 1
            i++;
        }
    }

    private static double decimalSqrt(double number, double i, double j)
    {
//calculates the middle of i and j
        double midvalue = (i+j)/2;
//finds the square of the midvalue
        double square = midvalue * midvalue;
//compares the midvalue with square up to n decimal places
        if(square==number||Math.abs(square-number)<0.0000001)
            return midvalue;
//if the square root belongs to second half
        else if(square>number)
            return decimalSqrt(number, i, midvalue);
//if the square root belongs to first half
        else
            return decimalSqrt(number, midvalue, j);
    }

    public static double squareRoot( double x )
  {
    return findSqrt(x, 0, x);
  }

  public static void main( String args[])
  {
    double[] inputs = {2, 4, 100};
    double[] expected_values = { 1.41421, 2, 10 };
    double threshold = 0.001;
    for(int i=0; i < inputs.length; i++)
    {
      if( Math.abs(squareRoot(inputs[i])-expected_values[i])>threshold )
      {
        System.out.printf( "Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i], squareRoot(inputs[i]) );
      }
    }
    System.out.println( "All tests passed");
  }
}