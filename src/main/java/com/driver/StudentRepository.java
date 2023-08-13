package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

   HashMap<String,Student> StudentRepo = new HashMap<>();

   HashMap<String,Teacher> TeacherRepo = new HashMap<>();

   HashMap<String,List<String>> MergeRepo = new HashMap<>();


   public HashMap<String, Student> getStudentRepo() {
      return StudentRepo;
   }

   public void setStudentRepo(HashMap<String, Student> studentRepo) {
      StudentRepo = studentRepo;
   }

   public HashMap<String, Teacher> getTeacherRepo() {
      return TeacherRepo;
   }

   public void setTeacherRepo(HashMap<String, Teacher> teacherRepo) {
      TeacherRepo = teacherRepo;
   }

   public HashMap<String, List<String>> getMergeRepo() {
      return MergeRepo;
   }

   public void setMergeRepo(HashMap<String, List<String>> mergeRepo) {
      MergeRepo = mergeRepo;
   }
}
