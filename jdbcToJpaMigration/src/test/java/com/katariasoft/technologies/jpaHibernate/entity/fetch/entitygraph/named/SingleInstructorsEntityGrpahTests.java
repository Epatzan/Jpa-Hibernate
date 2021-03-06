package com.katariasoft.technologies.jpaHibernate.entity.fetch.entitygraph.named;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.katariasoft.technologies.jpaHibernate.college.data.entity.IdProof;
import com.katariasoft.technologies.jpaHibernate.college.data.entity.Instructor;
import com.katariasoft.technologies.jpaHibernate.college.data.entity.Student;
import com.katariasoft.technologies.jpaHibernate.college.data.entity.Vehicle;
import com.katariasoft.technologies.jpaHibernate.college.data.utils.Executable;
import com.katariasoft.technologies.jpaHibernate.college.data.utils.TransactionExecutionTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SingleInstructorsEntityGrpahTests {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private TransactionExecutionTemplate transactionTemplate;

	@Test
	@Rollback(false)
	public void fetchInstructorsWithIdProof() {
		EntityGraph instructorIdProof = em.getEntityGraph("graph.instructor.idProof");
		doInTransaction(() -> {
			Instructor instructor = em.find(Instructor.class, 1,
					Collections.singletonMap("javax.persistence.fetchgraph", instructorIdProof));
			if (Objects.nonNull(instructor)) {
				IdProof idProof = instructor.getIdProof();
				Set<Vehicle> vehicles = instructor.getVehicles();
				Set<Student> students = instructor.getStudents();
				System.out.println(instructor);
				System.out.println(idProof);
				if (Objects.nonNull(vehicles))
					vehicles.forEach(v -> System.out.println(v.getVehicleNumber()));
				if (Objects.nonNull(students))
					students.forEach(s -> System.out.println(s.getName()));
			}
		});
	}

	@Test
	@Rollback(false)
	public void fetchInstructorsWithIdProofAndVehicles() {
		EntityGraph instructorIdProofVehicles = em.getEntityGraph("graph.instructor.idProof.vehicles");
		doInTransaction(() -> {
			Instructor instructor = em.find(Instructor.class, 1,
					Collections.singletonMap("javax.persistence.fetchgraph", instructorIdProofVehicles));
			if (Objects.nonNull(instructor)) {
				IdProof idProof = instructor.getIdProof();
				Set<Vehicle> vehicles = instructor.getVehicles();
				Set<Student> students = instructor.getStudents();
				System.out.println(instructor);
				System.out.println(idProof);
				if (Objects.nonNull(vehicles))
					vehicles.forEach(v -> System.out.println(v.getVehicleNumber()));
				if (Objects.nonNull(students))
					students.forEach(s -> System.out.println(s.getName()));
			}
		});
	}

	@Test
	@Rollback(false)
	public void fetchInstructorsWithIdProofAndVehiclesAndStudents() {
		EntityGraph instructorIdProofVehiclesStudents = em.getEntityGraph("graph.instructor.idProof.vehicles.students");
		doInTransaction(() -> {
			Instructor instructor = em.find(Instructor.class, 1,
					Collections.singletonMap("javax.persistence.fetchgraph", instructorIdProofVehiclesStudents));
			if (Objects.nonNull(instructor)) {
				IdProof idProof = instructor.getIdProof();
				Set<Vehicle> vehicles = instructor.getVehicles();
				Set<Student> students = instructor.getStudents();
				System.out.println(instructor);
				System.out.println(idProof);
				if (Objects.nonNull(vehicles))
					vehicles.forEach(v -> System.out.println(v.getVehicleNumber()));
				if (Objects.nonNull(students))
					students.forEach(s -> System.out.println(s.getName()));
			}
		});
	}

	@Test
	@Rollback(false)
	public void fetchInstructorsWithIdProofAndVehiclesAndStudentsAndTheirInstructors() {
		EntityGraph instructorIdProofVehiclesStudents = em
				.getEntityGraph("graph.instructor.idProof.vehicles.students.instructors");
		doInTransaction(() -> {
			Instructor instructor = em.find(Instructor.class, 1,
					Collections.singletonMap("javax.persistence.fetchgraph", instructorIdProofVehiclesStudents));
			if (Objects.nonNull(instructor)) {
				IdProof idProof = instructor.getIdProof();
				Set<Vehicle> vehicles = instructor.getVehicles();
				Set<Student> students = instructor.getStudents();
				System.out.println(instructor);
				System.out.println(idProof);
				if (Objects.nonNull(vehicles))
					vehicles.forEach(v -> System.out.println(v.getVehicleNumber()));
				if (Objects.nonNull(students))
					students.forEach(s -> System.out.println(s.getName()));
			}
		});
	}

	private void doInTransaction(Executable executable) {
		transactionTemplate.doInTransaction(executable);
	}

}
