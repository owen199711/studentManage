package jia.service.serviceImpl;

import jia.bean.sc;
import jia.bean.student;
import jia.bean.user;
import jia.mapper.studentMapper;
import jia.service.getStudentService;
import jia.vo.courseVo;
import jia.vo.coursev;
import jia.vo.studentVo;
import jia.vo.studentv;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;
public class getStudentServiceImpl implements getStudentService {
        @Autowired
        private studentMapper studentMapper;
        @Override
        public studentVo getStudent(int currentpage,int currentcount) throws Exception {
            studentVo studentVo=new studentVo();
            studentVo.setCurrentPage(currentpage);
            studentVo.setCurrentCount(currentcount);//一页显示条数
            int totalCount=0;
            try {
                totalCount= studentMapper.getCount();//总条数
            } catch (SQLException e) {
                e.printStackTrace();
            }
            studentVo.setTotalCount(totalCount);
            int totalPage = (int) Math.ceil(1.0*totalCount/currentcount);//分多少页
            studentVo.setTotalPage(totalPage);
            int index = (currentpage-1)*currentcount;//下标与页数的关系
            List<student> list= null;
            try {
                list = studentMapper.getStudent(index,currentcount);//拿到该页的信息
            } catch (Exception e) {
                e.printStackTrace();
            }
            studentVo.setList(list);
            return studentVo;//封装对象返回
        }
    @Override
    public boolean insertStudent(student student) throws Exception {
        int flag=studentMapper.insertStudent(student);
        return flag>0?true:false;
    }

    @Override
    public student getStudentBySno(String sno) throws Exception {
        return studentMapper.getStudentBySno(sno);
    }
    @Override
    public boolean updateStudentBySno(student student) throws Exception {
        int flg=studentMapper.updateStudentBySno(student);
        return flg>0?true:false;
    }
    public List<courseVo> getGradeBySno(String sno)throws Exception{
        return studentMapper.getGradeBySno(sno);
    }
    public boolean delStudent(String sno)throws Exception{
        return studentMapper.delStudent(sno)>0?true:false;
    }
    public boolean insertGrade(coursev coursev) throws Exception{
        sc s1=new sc();
        s1.setCon(1);
        s1.setSno(coursev.getSno());
        s1.setGrade(coursev.getSjk());

        sc s2=new sc();
        s2.setCon(2);
        s2.setSno(coursev.getSno());
        s2.setGrade(coursev.getByyl());

        sc s3=new sc();
        s3.setCon(3);
        s3.setSno(coursev.getSno());
        s3.setGrade(coursev.getGs());

        sc s4=new sc();
        s4.setCon(4);
        s4.setSno(coursev.getSno());
        s4.setGrade(coursev.getFbhs());

        sc s5=new sc();
        s5.setCon(5);
        s5.setSno(coursev.getSno());
        s5.setGrade(coursev.getGll());
        int flg=0;
        flg+=studentMapper.insertGrade(s1);
        flg+=studentMapper.insertGrade(s2);
        flg+=studentMapper.insertGrade(s3);
        flg+=studentMapper.insertGrade(s4);
        flg+=studentMapper.insertGrade(s5);
        return flg==5?true:false;
    }
    public studentv serch(String sname)throws Exception{
        String sno=studentMapper.getSnoByname(sname);
        List<sc>scList=studentMapper.serchgrade(sno);
        studentv studentv=new studentv();
        studentv.setStudent(studentMapper.serch(sname));
        coursev coursev=new coursev();
        if(scList.size()==5){
            coursev.setSjk(scList.get(0).getGrade());

            coursev.setByyl(scList.get(1).getGrade());

            coursev.setGs(scList.get(2).getGrade());

            coursev.setFbhs(scList.get(3).getGrade());

            coursev.setGll(scList.get(4).getGrade());

        }
        studentv.setCoursev(coursev);
        return studentv;
    }

    @Override
    public boolean login(user user) throws Exception {
            boolean flg=studentMapper.login(user) > 0 ? true:false;
        return flg;
    }
}
