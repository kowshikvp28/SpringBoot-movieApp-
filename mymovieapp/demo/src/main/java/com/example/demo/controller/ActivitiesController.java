package com.example.demo.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Activities;
import com.example.demo.service.ActivitiesService;
@RestController
public class ActivitiesController 
{
    private ActivitiesService activitiesService;
    public ActivitiesController(ActivitiesService activitiesService)
    {
        this.activitiesService = activitiesService;
    }
    @PostMapping("/post")
    public ResponseEntity<Activities> showinfo(@RequestBody Activities activities)
    {
        if (activitiesService.storedetails(activities))
        {
            return new ResponseEntity<>(activities,HttpStatus.OK);
        } 
        else
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/api/gets")
    public List<Activities> getdetail()
    {
       return activitiesService.getAllDetail();
    }
    @GetMapping("/api/activities/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Activities>> getMethod(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int pageSize, @PathVariable("field") String field) {
        List<Activities> ch = activitiesService.getByPaginateSort(offset, pageSize, field);
        if (ch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ch, HttpStatus.OK);
    }
    
}

