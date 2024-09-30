public class Polynomial {
	double[] coefficients;
	int[] exponents; 

	Polynomial() {
		this.coefficients = new double[]{0};
		this.exponents = new int[]{0};
	}

	Polynomial(double[] coefficients, int[] exponents) {
		if (coefficients.length == 0){
			this.coefficients = new double[]{0};
			this.exponents = new int[]{0};
		}
		else {
			this.coefficients = coefficients;
			this.exponents = exponents; 
		}
	}

	// too many cases ㅆㅂ
	Polynomial(File f) {
		String line = f.toString();
		String[] sub = line.split("x"), val;
		if (sub.length == 0) return new Polynomial(); 
		if (sub.length == 1) return new Polynomial(new double[]{Double.parseDboule(sub)}, new int[]{0});
		else {
			double[] coefficients = new double[sub.length + 1]; // max length
			int[] exponents = new int[sub.length + 1], index = 0;
			for (int i = 0; i < sub.length; i++) {
				if (sub.split("+").length == 1 && sub.split("-").length == 1) { // one variable
					coefficients[index] = Double.parseDouble(sub);
					if (index > 0) exponents[index-1] = 1; 
					index++;
				}
				else {
					String[] val = sub.split("+");
					if (val.length == 3) {

					}
					if (val.length == 2) {

					}
					else {
						val = sub.split("-");
						if (sub.startsWith("-")) coefficients[index] = -1 * Double.parse
					}

				}
			}
		}
		Integer.parseInt("");
	}

	public Polynomial add(Polynomial p) {
		double[] coefficients;
		int[] exponents;

		int len1 = this.exponents.length, len2 = p.exponents.length; 

		if (len1 >= len2) {
			coefficients = new double[len2]; 
			exponents = new int[len2]; 
			for (int i = 0; i < ; i++) {
				for (int j = 0; j < len2; j++)
					if (this.exponents[i] == p.exponents[j] && this.coefficients[i] + p.coefficients[j] != 0) {
						coefficients[i] = this.coefficients[i] + p.coefficients[j];
						exponents[i] = this.exponents[i];
						break;
					}
			}
			for (int i = len2; i < len1; i++) {
				coefficients[i] = this.coefficients[i];
				exponents[i] = this.exponents[i]; 
			}
		}

		else {
			coefficients = new double[len1]; 
			exponents = new int[len1]; 
			for (int i = 0; i < len1; i++) {
				for (int j = 0; j < len1; j++) {
					if (this.exponents[i] == p.exponents[j] && this.coefficients[i] + p.coefficients[j] != 0) {
						coefficients[i] = this.coefficients[i] + p.coefficients[j];
						exponents[i] = p.exponents[i];
					}
				}
			}
			for (int i = len1; i < len2; i++) {
				coefficients[i] = p.coefficients[i];
				exponents[i] = p.exponents[i]; 
			}
		}
		return new Polynomial(coefficients, exponents);
	} 

	public double evaluate(double x) {
		double result = 0, coefficient;
		int exponent;
		for (int i = 0; i < this.coefficients.length; i++) {
			coefficient = this.coefficients[i];
			exponent = this.exponents[i]
			result += coefficient * Math.pow(x, exponent);
		}
		return result;
	}

	public boolean hasRoot(double root) {
		if (evaluate(root) == 0) return true; 
		else return false;
	}

	public multiply (Polynomial p) {

		// determines the maximum length of the array
		int max1 = 0, max2 = 0; 
		for (int i = 0; i < this.exponents.length; i++) {
			if (this.exponents[i] > max1) max1 = this.exponents[i];
		}
		for (int j = 0; j < p.exponents.length; j++) {
			if (p.exponents[j] > max1) max1 = p.exponents[j];
		}
		int maxlen = max1 * max2 + 1;

		// multiiplication
		double[] temp_coefficients = new double[maxlen], coeff; 
		int[] temp_exponents = new int[maxlen], exp; 
		int index = 0; 
		for (int i = 0; i < this.coefficients.length; i++) {
			for (int j = 0; j < p.coefficients.length; j++) {
				exponent = this.exponents[i] + p.exponents[j]
				coefficient = this.coefficients[i] * p.coefficients[j]
				for (int k = 0; k < exponents.length; k++) { // search if already exists
					if (exponent == exponents[k]) coefficients[k] += coefficient;
				}
				coefficients[index] = coefficient; 
				exponent[index] = exponent;
				index++;
			}
		}

		// removing terms with a coefficient of 0
		index = 0;
		for (int i = 0; i < coefficients.length; i++) { 
			if (temp_coefficients[i] != 0) {
				coeff[index] = temp_coefficients[i];
				exp[index] = temp_exponents[i];
				index++
			}
		}
		return new Polynomial(coeff, exp);
	}


	public saveToFile(String filename) {

	}

}