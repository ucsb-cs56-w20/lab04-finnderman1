package edu.ucsb.cs56.ratcalc.model;

/** A class to represent a rational number

    with a numerator and denominator


    @author P. Conrad for CS56 F16


    */


public class Rational {


    private int num;

    private int denom;


    /** 

	greatest common divisor of a and b

	@param a first number

	@param b second number

	@return gcd of a and b

    */

    public static int gcd(int a, int b) {

		if (a==0)

			return b;

		else if (b==0)

			return a;

		else

			return gcd(b%a, a);

    }


	/** returns least common multiple of a and b 

	@param a first number

	@param b second number

	@return lcm of a and b 

	*/

	public static int lcm(int a, int b) {

		return Math.abs(a*b)/gcd(a,b);

	}

    

    public Rational() {

		this.num = 1;

		this.denom = 1;

    }


    public Rational(int num, int denom) {

		if (denom== 0) {

			throw new IllegalArgumentException("denominator may not be zero");

		}

		this.num = num;

		this.denom = denom;

			if (num != 0) {

				int gcd = Rational.gcd(num,denom);

				this.num /= gcd;

				this.denom /= gcd;

			}

			if(denom < 0)

			{

				num = num*-1;

			}

    }


	/** returns sum of this instance and r

	@param r

	@return sum of this and r 

	*/

	public Rational plus(Rational r) {

		int tden = Rational.lcm(this.denom, r.denom);

		return new Rational(((tden / this.denom) * this.num) + ((tden / r.denom) * r.num), tden);

	}


	/** returns sum of a and b 

	@param a first number

	@param b second number

	@return sum of a and b 

	*/

	public static Rational sum(Rational a, Rational b) {

		int tden = lcm(a.denom, b.denom);

		return new Rational(((tden / a.denom) * a.num) + ((tden / b.denom) * b.num), tden);

	}


	/** returns difference of this instance and r

	@param r first number

	@return difference of r and this 

	*/

	public Rational minus(Rational r) {

		r.num = r.num * -1;

		return plus(r);

	}


	/** returns difference of a and b 

	@param a first number

	@param b second number

	@return diference of a and b 

	*/

	public static Rational difference(Rational a, Rational b) {

		b.num = b.num*-1;

		return Rational.sum(a,b);

	}


    public int getNumerator() { return this.num; }

    public int getDenominator() { return this.denom; }


	/** returns product of this instance and r

	@param r first number

	@return product of r and this 

	*/

    public Rational times(Rational r) {

	return new Rational(this.num * r.num,

			    this.denom * r.denom);

    }


	/** returns product of a and b 

	@param a first number

	@param b second number

	@return product of a and b 

	*/

    public static Rational product(Rational a, Rational b) {

	return new Rational(a.num * b.num,

			    a.denom * b.denom);

    }


	/** returns the reciprocal of this 

	@return reciprocal of this

	*/

	public Rational reciprocalOf() {

		if(this.num == 0)

		{

			throw new ArithmeticException("denominator may not be zero");

		}

		else

		{

			return new Rational(this.denom, this.num);

		}

	}


	/** returns quotient of this instance and r

	@param r first number

	@return quotient of r and this 

	*/

	public Rational dividedBy(Rational r) {

		Rational temp = r.reciprocalOf();

		return times(temp);

	}


	/** returns quotient of a and b 

	@param a first number

	@param b second number

	@return quotient of a and b 

	*/

	public static Rational quotient(Rational a, Rational b) {

		Rational temp = b.reciprocalOf();

		return product(a, temp);

	}


	/** returns the string format of rational number of this

	@return fraction in string format

	*/

    public String toString() {

	if (denom == 1 || num == 0)

	    return "" + num;

	if(denom < 0)

	{

		num = num * -1;

		denom = denom*-1;

	}

	return num + "/" + denom;

    }


    

    /** 

	For testing getters.  

	@param args unused

     */


    public static void main (String [] args) {

	Rational r = new Rational(5,7);

	System.out.println("r.getNumerator()=" + r.getNumerator());

	System.out.println("r.getDenominator()=" + r.getDenominator());

    }


    

}
