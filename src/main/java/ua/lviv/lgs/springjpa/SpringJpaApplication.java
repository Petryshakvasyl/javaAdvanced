package ua.lviv.lgs.springjpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Sort;
import ua.lviv.lgs.springjpa.entity.Student;
import ua.lviv.lgs.springjpa.repository.StudentRepository;
import ua.lviv.lgs.springjpa.service.StudentService;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
@Slf4j
public class SpringJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);

		StudentService service = context.getBean(StudentService.class);
		StudentRepository repository = context.getBean(StudentRepository.class);

		//		List<Student> students = createStudents(100);
		//		repository.saveAll(students);
		//
		//		List<Student> firstCourseStudents = service.findByCource(1);
		//		System.out.println(firstCourseStudents);
		//		System.out.println(firstCourseStudents.size());

		List<Student> students = repository.findByLastNameAndFirstName("LastName10", "Name10");
		//		List<Student> studentsLike = repository.findByLastNameLike("%Name1%");

		//		System.out.println(students);
		//		System.out.println(studentsLike);

		Optional<Student> studentOptional = repository.findCustomStudent(2, "Name2", "LastName2");

		studentOptional.ifPresent(System.out::println);

		Iterable<Student> students1 = repository.findAll(Sort.by(Sort.Direction.DESC, "course"));

		System.out.println(students1);

	}

	private static List<Student> createStudents(int count) {
		return IntStream.range(0, count).mapToObj(i -> {
			Student student = new Student();
			student.setCourse(ThreadLocalRandom.current().nextInt(1, 5));
			student.setFirstName("Name" + i);
			student.setLastName("LastName" + i);
			return student;
		}).collect(Collectors.toList());
	}

}
