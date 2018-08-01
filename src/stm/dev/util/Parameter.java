package stm.dev.util;

public class Parameter<T> {
	T value;
	T org;
	
	public void setOrgAndValue(T v) {
		org = v;
		value = v;
	}
	
	public void setValue(T v) {
		value = v;
	}
	
	public void setOrg(T v) {
		org = v;
	}
	
	public T getOrg() {
		return org;
	}
	
	public T getValue() {
		return value;
	}
}
