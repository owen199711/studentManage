package jia.mapper;

import jia.bean.student;
import jia.bean.user;
import jia.vo.courseVo;
import jia.bean.sc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface studentMapper {
    public List<student> getStudent(@Param(value = "index") int index, @Param(value = "currentcount") int currentcount)throws Exception;
    public int getCount() throws Exception;
    public int insertStudent(@Param(value = "student")student student)  throws Exception;
    public student getStudentBySno(@Param(value = "sno")String sno)throws Exception;
    public int updateStudentBySno(@Param(value = "student")student student)  throws Exception;
    public List<courseVo> getGradeBySno(@Param(value = "sno")String sno)throws Exception;
    public int delStudent(@Param(value = "sno")String sno)throws Exception;
    public int insertGrade(@Param(value = "sc")sc sc) throws Exception;
    public student serch(@Param(value = "sname")String sname)throws Exception;
    public List<sc> serchgrade(@Param(value = "sno")String sno)throws Exception;
    public String getSnoByname(@Param(value = "sname")String sname)throws Exception;
    public int login(@Param(value = "user")user user)throws Exception;
}
