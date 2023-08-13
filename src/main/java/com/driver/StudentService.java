package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository Repo;

    ///1
 public void addStudent(Student s){

     HashMap<String,Student> studRepo = Repo.getStudentRepo();

     String s1 = s.getName();

     studRepo.put(s1,s);

     Repo.setStudentRepo(studRepo);
 }
  ///2
 public void addTeacher(Teacher t){

     HashMap<String,Teacher> Trepo = Repo.getTeacherRepo();

     String t1 = t.getName();

     Trepo.put(t1,t);
     ///adding in teachers Repo
     Repo.setTeacherRepo(Trepo);

     HashMap<String,List<String>> merge = Repo.getMergeRepo();
     ///adding new Teacher and new list in merge repo
     merge.put(t1,new ArrayList<>());

     Repo.setMergeRepo(merge);
 }


 ///3
 public void MergeStudent (String s , String t){
//
//     HashMap<String,Teacher> Trepo = Repo.getTeacherRepo();
//     HashMap<String,Student> studRepo = Repo.getStudentRepo();

     HashMap<String,List<String>> merge = Repo.getMergeRepo();

     List<String> list = merge.get(t);

     list.add(s);

     merge.put(t,list);

     Repo.setMergeRepo(merge);
 }


 ///4
 public Student getStudent(String name){

     HashMap<String,Student> studRepo = Repo.getStudentRepo();

     return studRepo.get(name);
 }

    ///5
    public Teacher getTeacher(String name){

     HashMap<String,Teacher> Trepo = Repo.getTeacherRepo();

     return Trepo.get(name);

    }

    ///6
    public List<String> getMergedStudents (String name){

        HashMap<String,List<String>> merge = Repo.getMergeRepo();

        List<String> list = merge.get(name);

        return list;
    }

    ///7
    public List<String> getAllStudents (){

     HashMap<String,Student> studRepo = Repo.getStudentRepo();

     List<String>list = new ArrayList<>();

     for(String key : studRepo.keySet()){
         list.add(key);
     }

     return list;
    }

    ///8
    public void DeleteTeacher (String name){

        HashMap<String,Teacher> Trepo = Repo.getTeacherRepo();
        HashMap<String,List<String>> merge = Repo.getMergeRepo();

        Trepo.remove(name);
        merge.remove(name);

        Repo.setMergeRepo(merge);
        Repo.setTeacherRepo(Trepo);
    }

    ///9
    public void DeleteAllTeachers(){

        HashMap<String,Teacher> Trepo = Repo.getTeacherRepo();
        HashMap<String,List<String>> merge = Repo.getMergeRepo();

        Trepo.clear();
        merge.clear();

        Repo.setMergeRepo(merge);
        Repo.setTeacherRepo(Trepo);

    }





}
