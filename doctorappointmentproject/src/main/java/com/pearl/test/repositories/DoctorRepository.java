package com.pearl.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pearl.test.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long>
{
	

}
