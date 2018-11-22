package i3.i3redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import i3.i3redis.model.Student;
@Repository
public interface StudentRepository  extends CrudRepository<Student, String>{

}
