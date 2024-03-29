package com.EMS.EMS_API.conroller;

import com.EMS.EMS_API.entity.Institute;
import com.EMS.EMS_API.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/institutes")
    public class InstituteController {

        private final InstituteService instituteService;

        @Autowired
        public InstituteController(InstituteService instituteService) {
            this.instituteService = instituteService;
        }

        /*@PostMapping
        public ResponseEntity<Institute> createInstitute(@RequestBody Institute institute) {
            Institute createdInstitute = instituteService.createInstitute(institute);
            return new ResponseEntity<>(createdInstitute, HttpStatus.CREATED);
        }*/

        @GetMapping
        public ResponseEntity<List<Institute>> getAllInstitute() {
            List<Institute> institutes = instituteService.getAllInstitute();
            return new ResponseEntity<>(institutes, HttpStatus.OK);
        }

        @GetMapping("/academic-term")
        public ResponseEntity<List<AcademicTerm>> getAllAcademicTerm() {
            List<AcademicTerm> academicTerms = instituteService.getAllAcademicTerm();
            return new ResponseEntity<>(academicTerms, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Institute> getInstituteById(@PathVariable Long id) {
            Institute institute = instituteService.getInstituteById(id);
            if (institute != null) {
                return new ResponseEntity<>(institute, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        /*@PutMapping("/{id}")
        public ResponseEntity<Institute> updateInstitute(@PathVariable Long id, @RequestBody Institute updatedInstitute) {
            Institute institute = instituteService.updateInstitute(id, updatedInstitute);
            if (institute != null) {
                return new ResponseEntity<>(institute, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }*/

        /*@DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteInstitute(@PathVariable Long id) {
            instituteService.deleteInstitute(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }*/
    }


