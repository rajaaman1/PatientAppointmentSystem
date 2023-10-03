package com.pearl.test.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pearl.test.entities.Appointment;


public interface AppointmentRepository extends JpaRepository<Appointment,Long> 
{
	List<Appointment> findByDoctorIdAndDateTimeAfter(Long doctorId, LocalDateTime dateTime);

}
