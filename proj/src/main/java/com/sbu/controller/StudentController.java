/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.controller;

import com.sbu.controller.model.Student;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/student")
public class StudentController {

   @RequestMapping(value = "/submit", method = RequestMethod.GET)
   public String student() {
      return "student";
   }
   
   @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
   public String addStudent(@ModelAttribute("SpringWeb")Student student, Model model) {
      model.addAttribute("name", student.getName());
      model.addAttribute("age", student.getAge());
      model.addAttribute("id", student.getId());
      return "studentinfo";
   }
   
   @RequestMapping(value = "/addStudent2", method = RequestMethod.POST)
   public String addStudent2(@ModelAttribute("SpringWeb")Student student, Model model, HttpServletRequest request) {
      model.addAttribute("name", student.getName());
      model.addAttribute("age", student.getAge());
      model.addAttribute("id", student.getId());
      
      return "studentinfo";
   }
}