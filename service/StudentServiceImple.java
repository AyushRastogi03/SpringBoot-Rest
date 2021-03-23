package com.example.demo.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.pojo.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StudentServiceImple implements StudentService {
	
           ObjectMapper mapper = new ObjectMapper();
          
           //1 - EndPoint to fetch All Details
           
           public List<Student> findAll(){
        	   try {
        		   BufferedReader br = new BufferedReader(new FileReader("D:\\Student.json"));
        		   
        		   List<Student> st = mapper.readValue(br, new TypeReference<List<Student>>(){});
        		   return st;
        	   }
        	   catch(IOException e) {
        		   e.printStackTrace();
        	   }
        	   
        	   return null;
           }
           
           //2 - Fetch data depending on the Role 
           public List<Student> findByRole(String role){
        	   try {
        		   BufferedReader br = new BufferedReader(new FileReader("D:\\Student.json"));
        		   List<Student> st = mapper.readValue(br, new TypeReference<List<Student>>(){});
        		   List<Student> li2 = new ArrayList<>();
        		   
        		   for(Student s : st) {
        			   li2 = st.stream().filter(p -> p.getRole().equalsIgnoreCase(role)).collect(Collectors.toList());
        		   }
        		   
        		   return li2;
        		   
        	   }
        	   catch(IOException e) {
        		   e.printStackTrace();
        	   }
        	   
        	   return null ;
           }
           
           
           //3 - fetch data only for onboarded Student
           
           public List<Student> findOnboarded(boolean onboarded)
           {
        	   try {
        		   BufferedReader br = new BufferedReader(new FileReader("D:\\Student.json"));
        		   List<Student> st = mapper.readValue(br, new TypeReference<List<Student>>(){});
        		   List<Student> li2 = new ArrayList<>();
        		   
        		   for(Student s : st) {
                           if(s.isOnboarded()==onboarded) {
                        	   li2.add(s);
                           }
        		   }
        		   
        		   return li2;
        		   
        	   }
        	   catch(IOException e) {
        		   e.printStackTrace();
        	   }
        	   
        	   return null ;
           }
           
           
           //4 - Fetch Data of only onboarded student and write on new file 
           
           public List<Student> writeOnboarded(boolean onboarded)
           {
        	   try {
        		   BufferedReader br = new BufferedReader(new FileReader("D:\\Student.json"));
        		   List<Student> st = mapper.readValue(br, new TypeReference<List<Student>>(){});
        		   List<Student> li = new ArrayList<>();
        		   
        		   for(Student s : st) {
        			   if(s.isOnboarded()) {
        				   li.add(s);
        			   }
        		   }
        		   BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\write.json"));
        		   mapper.writerWithDefaultPrettyPrinter().writeValue(bw,li);
        		   return li;
        	   } 
        	   catch(IOException e) {
        		   e.printStackTrace();
        	   }
        	   
        	   return null ;
           }
           
           //5 - post data and write on a new file 
           
           public void addCompany(List<Student> student)
           {
        	   try {
        		   List<Student> l = new ArrayList<>();
        		   for(Student s : student) {
        			   if(s.getCompany().equalsIgnoreCase("Verizon")) {
        				   l.add(s);
        			   }
        		   }
        		   BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\write.json"));
        		   mapper.writerWithDefaultPrettyPrinter().writeValue(bw,l);
        		   
        	   }
        	   catch(IOException e) {
        		   e.printStackTrace();
        	   }
        	   
        	   
           }
           
           //6- Filter Data using a search Criteria (Only Single end point to handle multiple search criteria)
           
           public List<Student> searchData(String firstName,String lastName,String role,String company,int age,boolean onboarded){
        	   List<Student> q = new ArrayList<>();
        	   try {
        		   BufferedReader br = new BufferedReader(new FileReader("D:\\Student.json"));
        		   List<Student> st = mapper.readValue(br, new TypeReference<List<Student>>(){});
        		   for(Student s : st) {
        			   if(s.getFirstName().equalsIgnoreCase(firstName)){
        				   q.add(s);
        			   }
        			   else if(s.getLastName().equalsIgnoreCase(lastName)) {
        				   q.add(s);
        			   }
        			   else if(s.getRole().equalsIgnoreCase(role)) {
        				   q.add(s);
        			   }
        			   else if(s.getAge()==age) {
        				   q.add(s);
        			   }
        			   else if(s.getCompany().equalsIgnoreCase(company)) {
        				   q.add(s);
        			   }
        		   }
        		   return q;
        	   }
        	   catch(IOException e) {
        		   e.printStackTrace();
        	   }
        	   return null ;
           }
           
           
           
           
           
           
}
