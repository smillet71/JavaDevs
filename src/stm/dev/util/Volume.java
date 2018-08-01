package stm.dev.util;

public class Volume {
	// type de volume
	public enum VolumeType { SPHERE, CUBE }  ;
	//
	private VolumeType type = VolumeType.SPHERE;
	// position relative
	private int dpos[];
	// rayon dans le cas d'une sphere
	private int radius=1;
	// mesures dans le cas d'un "cube"
	private int length=1, width=1, height=1;
	//
	
	//
	public static Volume buildSphere(int radius) {
		Volume v = new Volume();
		v.type = VolumeType.SPHERE;
		v.radius = radius;
		return v;
	}
	
	//
	public static Volume buildCube(int length, int width, int height) {
		Volume v = new Volume();
		v.type = VolumeType.CUBE;
		v.length = length;
		v.width = width;
		v.height = height;
		return v;
	}
	
	//
	public VolumeType getType() {
		return type;
	}
	public void setType(VolumeType type) {
		this.type = type;
	}
	public int[] getDPos() {
		return dpos;
	}
	public void setDPos(int[] dpos) {
		this.dpos = dpos;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
