/**
 * 
 */
package com.org.model;

/**
 * @author MYPC
 *
 */
public class FeatureDetail {
	
public FeatureDetail(){
		
	}
	public FeatureDetail(int pre, int curr, int next){
		this.pre = pre;
		this.curr = curr;
		this.next = next;
	}
	public int getPre() {
		return pre;
	}
	public void setPre(int pre) {
		this.pre = pre;
	}
	public int getCurr() {
		return curr;
	}
	public void setCurr(int curr) {
		this.curr = curr;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	private int pre;
	private int curr;
	private int next;

}
