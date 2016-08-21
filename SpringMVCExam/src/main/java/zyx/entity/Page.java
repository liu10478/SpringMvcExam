package zyx.entity;

public class Page {
	private int begin;
	private int num;
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Page [begin=" + begin + ", num=" + num + "]";
	}
	
}
