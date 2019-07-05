/**
 * 
 */
package com.kiddie.vo;

import java.util.List;

import com.kiddie.vo.base.BaseVo;

/**
 * @author xuzhaojie
 *
 *         2018年8月3日 下午5:29:17
 */
public class PageVo<T> extends BaseVo {

	private List<T> list;
	private long total = 0;//
	private long totalPage = 1;
	private int size = 10;
	private int page = 1;

	private void resize() {
		this.totalPage = (this.total % this.size) == 0 ? (this.total / this.size) : ((this.total / this.size) + 1);
		if (this.page < 1) {
			this.page = 1;
		} else if (this.page > this.totalPage) {
			this.page = Integer.valueOf(this.totalPage + "");
		}
	}

	public PageVo(Integer page, Integer size) {
		if (page != null)
			this.page = Math.abs(page);
		if (size != null) {
			if (size <= 0) {
				this.size = 10;
			} else if (size > 100) {
				this.size = 100;
			} else {
				this.size = size;
			}
		}
	}

	/**
	 * @return the list
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
		if (this.total < 0)
			this.total = 0 - this.total;
		resize();
	}

	/**
	 * @return the totalPage
	 */
	public long getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "PageVo [list=" + list + ", total=" + total + ", totalPage=" + totalPage + ", size=" + size + ", page="
				+ page + "]";
	}

}
