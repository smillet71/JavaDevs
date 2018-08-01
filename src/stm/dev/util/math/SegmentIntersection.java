package stm.dev.util.math;

import java.awt.geom.Point2D;

/**
 * 
 * @author Internet Forum
 *
 */
public class SegmentIntersection {

	public static boolean test(Point2D.Float A,Point2D.Float B,Point2D.Float C,Point2D.Float D)
	{
		//
		float Ax = A.x;
		float Ay = A.y;
		float Bx = B.x;
		float By = B.y;
		float Cx = C.x;
		float Cy = C.y;
		float Dx = D.x;
		float Dy = D.y;
		//
		double Sx;
		double Sy;
		
		//
		if(Ax==Bx)
		{
			if(Cx==Dx) return false;
			else
			{
				double pCD = (Cy-Dy)/(Cx-Dx);
				Sx = Ax;
				Sy = pCD*(Ax-Cx)+Cy;
			}
		}
		else
		{
			if(Cx==Dx)
			{
				double pAB = (Ay-By)/(Ax-Bx);
				Sx = Cx;
				Sy = pAB*(Cx-Ax)+Ay;
			}
			else
			{
				double pCD = (Cy-Dy)/(Cx-Dx);
				double pAB = (Ay-By)/(Ax-Bx);
				double oCD = Cy-pCD*Cx;
				double oAB = Ay-pAB*Ax;
				Sx = (oAB-oCD)/(pCD-pAB);
				Sy = pCD*Sx+oCD;
			}
		}
		//
		if((Sx<Ax && Sx<Bx)|(Sx>Ax && Sx>Bx) | (Sx<Cx && Sx<Dx)|(Sx>Cx && Sx>Dx)
				| (Sy<Ay && Sy<By)|(Sy>Ay && Sy>By) | (Sy<Cy && Sy<Dy)|(Sy>Cy && Sy>Dy)) return false;
		  return true; //or :     return new Point2D.Float((float)Sx,(float)Sy)
	}
}
