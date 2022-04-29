package jia.vo;

import jia.bean.student;

public class studentv {
    private student student;
    private coursev coursev;
    public jia.bean.student getStudent() {
        return student;
    }

    public void setStudent(jia.bean.student student) {
        this.student = student;
    }

    public jia.vo.coursev getCoursev() {
        return coursev;
    }

    public void setCoursev(jia.vo.coursev coursev) {
        this.coursev = coursev;
    }
}
