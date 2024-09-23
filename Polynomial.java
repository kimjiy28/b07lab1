public class Polynomial {
	double[] coefficients;

	Polynomial() {
		this.coefficients = new double[]{0};
	}

	Polynomial(double[] c) {
		this.coefficients = c; 
	}

	public Polynomial add(Polynomial p) {
		int p1 = this.coefficients.length, p2 = p.coefficients.length, i; 
		double[] result;
		if (p1 != p2){
			if (p1 > p2) {
				result = new double[p1];
				for (i = 0; i < p2; i++)
					result[i] = this.coefficients[i] + p.coefficients[i];
				for (i = p2; i < p1; i++)
					result[i] = this.coefficients[i];
			}
			else {
				result = new double[p2];
				for (i = 0; i < p1; i++)
					result[i] = this.coefficients[i] + p.coefficients[i];
				for (i = p1; i < p2; i++)
					result[i] = p.coefficients[i];
			}
		}
		else {
			result = new double[p1];
			for (i = 0; i < p1; i++)
				result[i] = this.coefficients[i] + p.coefficients[i];
		}
		return new Polynomial(result);
	} 

	public double evaluate(double x) {
		double result = 0;
		for (int i = 0; i < this.coefficients.length; i++) {
			result += this.coefficients[i] * Math.pow(x, i);
		}
		return result;
	}

	public boolean hasRoot(double root) {
		if (evaluate(root) == 0) return true; 
		else return false;
	}

}