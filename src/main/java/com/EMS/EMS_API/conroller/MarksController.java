package com.EMS.EMS_API.conroller;



import com.EMS.EMS_API.entity.Marks;
import com.EMS.EMS_API.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/newmarks")
    public class MarksController {

        private final MarkService newMarkService;

        @Autowired
        public MarksController(MarkService newMarkService) {
            this.newMarkService = newMarkService;
        }

        @PostMapping
        public ResponseEntity<Marks> createNewMark(@RequestBody Marks newMark) {
            Marks createdNewMark = newMarkService.createNewMark(newMark);
            return new ResponseEntity<>(createdNewMark, HttpStatus.CREATED);
        }

        @GetMapping
        public ResponseEntity<List<Marks>> getAllNewMarks() {
            List<Marks> newMarks = newMarkService.getAllNewMarks();
            return new ResponseEntity<>(newMarks, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Marks> getNewMarkById(@PathVariable Long id) {
            Marks newMark = newMarkService.getNewMarkById(id);
            if (newMark != null) {
                return new ResponseEntity<>(newMark, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @GetMapping("/task/{taskId}")
        public ResponseEntity<Marks> getNewMarkByTaskId(@PathVariable Long taskId) {
            Marks newMark = newMarkService.getNewMarkByTaskId(taskId);
            if (newMark != null) {
                return new ResponseEntity<>(newMark, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<Marks> updateNewMark(@PathVariable Long id, @RequestBody Marks updatedNewMark) {
            Marks newMark = newMarkService.updateNewMark(id, updatedNewMark);
            if (newMark != null) {
                return new ResponseEntity<>(newMark, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteNewMark(@PathVariable Long id) {
            newMarkService.deleteNewMark(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


