package i3.i3redis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import i3.i3redis.model.Movie;
import i3.i3redis.model.Student;
import i3.i3redis.repository.RedisRepository;
import i3.i3redis.repository.StudentRepository;

@Controller
@RequestMapping("/")
public class WebController {
    
    @Autowired
    private RedisRepository redisRepository;
    @Autowired
    private StudentRepository studentRepository;
    

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/keys")
    public @ResponseBody Map<Object, Object> keys() {
    	Student retrievedStudent = 
    			  studentRepository.findById("Eng2015001").get();
    	System.out.println("retrievedStudent:: "+retrievedStudent);
        return redisRepository.findAllMovies();
    }

    @RequestMapping("/values")
    public @ResponseBody Map<String, String> findAll() {
        Map<Object, Object> aa = redisRepository.findAllMovies();
        Map<String, String> map = new HashMap<String, String>();
        for(Map.Entry<Object, Object> entry : aa.entrySet()){
            String key = (String) entry.getKey();
            map.put(key, aa.get(key).toString());
        }
        return map;
    }
    @RequestMapping("/student/values")
    public @ResponseBody Map<String, String> StudentFindAll() {
           List<Student> students = new ArrayList<>();
           Map<String, String> maps=new HashMap<>();
        studentRepository.findAll().forEach(students::add);
        students.forEach(s->{
        	System.out.println("students"+s.getName());
        	maps.put(s.getId(), s.getName());
        });
        return maps;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(
        @RequestParam String key,
        @RequestParam String value) {
        
        Movie movie = new Movie(key, value);
        
        redisRepository.add(movie);
        
        Student student = new Student(
        		key, value, Student.Gender.MALE, 1);
        		studentRepository.save(student);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<String> delete(@RequestParam String key) {
        redisRepository.delete(key);
       
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
