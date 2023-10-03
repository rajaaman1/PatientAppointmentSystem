package com.pearl.test.restcontroller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pearl.test.entities.Appointment;
import com.pearl.test.repositories.AppointmentRepository;

@RestController
@RequestMapping("/appointments")
public class AppointmentRestController 
{
	@Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/available/{doctorId}")
    public List<Appointment> getAvailableAppointments(@PathVariable Long doctorId) {
        LocalDateTime now = LocalDateTime.now();
        return appointmentRepository.findByDoctorIdAndDateTimeAfter(doctorId, now);
    }

    @PostMapping
    public void bookAppointment(@RequestBody Appointment appointment) 
    {
         appointmentRepository.save(appointment);
    }
}


