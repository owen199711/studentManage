package jia.service;
import jia.bean.sc;
import jia.bean.student;
import jia.bean.user;
import jia.vo.courseVo;
import jia.vo.coursev;
import jia.vo.studentVo;
import jia.vo.studentv;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface getStudentService {
    public studentVo getStudent(int currentpage,int currentcount)throws Exception;
    public boolean insertStudent(student student) throws Exception;
    public student getStudentBySno(String sno)throws Exception;
    public boolean updateStudentBySno(student student) throws Exception;
    public List<courseVo> getGradeBySno(String sno)throws Exception;
    public boolean delStudent(String sno)throws Exception;
    public boolean insertGrade(coursev coursev) throws Exception;
    public studentv serch(String sname)throws Exception;
    public boolean login(user user)throws Exception;
}
