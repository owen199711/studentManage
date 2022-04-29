package jia.vo;

import jia.bean.student;

import java.util.ArrayList;
import java.util.List;

public class studentVo {
    private int currentPage;//当前页
    private int currentCount;//当前页的显示条数
    private int totalPage;//总页数
    private int totalCount;//总条数
    private List<student> list=new ArrayList<>();

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<student> getList() {
        return list;
    }

    public void setList(List<student> list) {
        this.list = list;
    }
}
