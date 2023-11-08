package com.EMS.EMS_API.conroller;



import com.EMS.EMS_API.entity.NewMarks;
import com.EMS.EMS_API.service.NewMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/newmarks")
    public class NewMarkController {

        private final NewMarkService newMarkService;

        @Autowired
        public NewMarkController(NewMarkService newMarkService) {
            this.newMarkService = newMarkService;
        }

        @PostMapping
        public ResponseEntity<NewMarks> createNewMark(@RequestBody NewMarks newMark) {
            NewMarks createdNewMark = newMarkService.createNewMark(newMark);
            return new ResponseEntity<>(createdNewMark, HttpStatus.CREATED);
        }

        @GetMapping
        public ResponseEntity<List<NewMarks>> getAllNewMarks() {
            List<NewMarks> newMarks = newMarkService.getAllNewMarks();
            return new ResponseEntity<>(newMarks, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<NewMarks> getNewMarkById(@PathVariable Long id) {
            NewMarks newMark = newMarkService.getNewMarkById(id);
            if (newMark != null) {
                return new ResponseEntity<>(newMark, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @GetMapping("/task/{taskId}")
        public ResponseEntity<NewMarks> getNewMarkByTaskId(@PathVariable Long taskId) {
            NewMarks newMark = newMarkService.getNewMarkByTaskId(taskId);
            if (newMark != null) {
                return new ResponseEntity<>(newMark, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<NewMarks> updateNewMark(@PathVariable Long id, @RequestBody NewMarks updatedNewMark) {
            NewMarks newMark = newMarkService.updateNewMark(id, updatedNewMark);
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

}
