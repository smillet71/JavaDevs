package stm.dev.util.math;

/**
 * 
 * @author smill
 *
 */
public class Geom2D {

	public static double dist2d(double x0, double y0, double x1, double y1)
	{
		return Math.sqrt(Math.pow(x1-x0, 2)+Math.pow(y1-y0, 2));
	}
}
