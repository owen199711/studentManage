package jia.controller;
import jia.bean.student;
import jia.bean.user;
import jia.service.getStudentService;
import jia.vo.*;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
@Controller
public class studentController {
    @Autowired
    private getStudentService studentService;
    @RequestMapping("getstudent")//显示
    public void getStrudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String currentPageStr = request.getParameter("currentPage");
        if(currentPageStr==null) currentPageStr="1";
        int currentPage = Integer.parseInt(currentPageStr);
        //认为每页显示10条
        int currentCount = 15;
        studentVo students=studentService.getStudent(currentPage,currentCount);
        request.setAttribute("students",students);
        request.getRequestDispatcher("/design.jsp").forward(request,response);
    }
    @RequestMapping("insertStudent")//插入
    public void insertStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        student student=new student();
        Map<String,String[]> map=request.getParameterMap();
        BeanUtils.populate(student,map);
        boolean flag=studentService.insertStudent(student);
        if(flag){
            response.sendRedirect(request.getContextPath()+"/success.jsp");
        }else{
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
    @RequestMapping("beforEdit")//修改前数据准备
    public void beforEdit(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String sno=request.getParameter("sno");
        student student=studentService.getStudentBySno(sno);
        request.setAttribute("student",student);
        request.getRequestDispatcher("/edit.jsp").forward(request,response);
    }
    @RequestMapping("updateStudent")//更新学生
    public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{
        student student=new student();
        Map<String,String[]> map=request.getParameterMap();
        BeanUtils.populate(student,map);
        boolean flg= studentService.updateStudentBySno(student);
        if(flg){
            response.sendRedirect(request.getContextPath()+"/success.jsp");
        }else{
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
    @RequestMapping("getGrade")//查询成绩
    public void getGrade(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String sno= request.getParameter("sno");
        List<courseVo> courseVos= studentService.getGradeBySno(sno);
        request.setAttribute("courseVos",courseVos);
        request.getRequestDispatcher("/grade.jsp").forward(request,response);
    }
    @RequestMapping("delStudent")//删除
    public void delStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String sno = request.getParameter("sno");
        boolean flg=studentService.delStudent(sno);
        if(flg){
            response.sendRedirect(request.getContextPath()+"/success.jsp");
        }else{
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
    @RequestMapping("insertGrade")//添加成绩
    public void insertGrade(HttpServletRequest request, HttpServletResponse response) throws Exception {
        coursev coursev=new coursev();
        Map<String ,String[]>map=request.getParameterMap();
        BeanUtils.populate(coursev,map);
        boolean flg=studentService.insertGrade(coursev);
        if(flg){
            response.sendRedirect(request.getContextPath()+"/success.jsp");
        }else{
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
    @RequestMapping("beforeinsertGrade")//添加成绩前数据准备
    public void beforeinsertGrade(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String sno=request.getParameter("sno");
        List<courseVo> courseVos= studentService.getGradeBySno(sno);
        if(courseVos.size()==0){
            student student=new student();
            student.setSno(sno);
            request.setAttribute("student",student);
            request.getRequestDispatcher("/grade1.jsp").forward(request,response);
        }else{
            response.sendRedirect(request.getContextPath()+"/exist.jsp");
        }

    }
    @RequestMapping("serch")//查询
    public void serch(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String sname=request.getParameter("sname");
        String s=new String(sname.getBytes("ISO8859_1"),"utf-8");
        studentv student=studentService.serch(s);
        if(student.getStudent()==null){
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }else{
            request.setAttribute("student",student);
            request.getRequestDispatcher("/student.jsp").forward(request,response);
        }
    }
    @RequestMapping(value = "login",method = RequestMethod.POST)//查询
    public void login(HttpServletRequest request, HttpServletResponse response)throws Exception{
        request.setCharacterEncoding("utf-8");
        user user=new user();
        Map<String,String[]>map=request.getParameterMap();
        BeanUtils.populate(user,map);
        boolean flg=studentService.login(user);
        if(flg){
            response.sendRedirect(request.getContextPath()+"/getstudent");
        }else{
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}
