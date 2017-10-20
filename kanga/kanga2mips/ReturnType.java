package kanga.kanga2mips;

public class ReturnType {
	public String type;
	public String value;
	public ReturnType(String _type, String _value) {
		type = _type;
		value = _value;
	}
	public String toString() {
		return value;
	}
}