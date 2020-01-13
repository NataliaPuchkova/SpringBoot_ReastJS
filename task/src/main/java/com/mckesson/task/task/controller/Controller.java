package com.mckesson.task.task.controller;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import com.mckesson.task.task.model.*;

import java.time.OffsetDateTime;
import java.util.*;
// https://developer.okta.com/blog/2018/07/19/simple-crud-react-and-spring-boot
@RestController
@RequestMapping("/task")
public class Controller {
    private final Logger log = LoggerFactory.getLogger(Controller.class);

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/getsmth")
    public String getHello(){
        return "Hello World!";
    }

    @RequestMapping(value = "/getOne", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Task getTask(){
        Task tsk = new Task();
        tsk.setText("This is an messageS");
        tsk.setDate(OffsetDateTime.now());
        return tsk;
    }

    @RequestMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public ResponseEntity<Collection<Task>> getAllEmployeesJSON() {
        Collection<Task> list = new ArrayList<Task>();
        Task tsk = new Task();
        tsk.setText("This is an message 1");
        tsk.setDate(OffsetDateTime.now());
        list.add(tsk);
        tsk = new Task();
        tsk.setText("This is an message 2");
        tsk.setDate(OffsetDateTime.now().minusDays(2));
        list.add(tsk);
        return new ResponseEntity<Collection<Task>>(list, HttpStatus.OK);
    }
   /*
    @RequestMapping(value = "/getAll", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> getTasks(){
        Collection<Task> list = new ArrayList<Task>();
        Task tsk = new Task();
        tsk.setText("This is an message 1");
        tsk.setDate(OffsetDateTime.now());
        list.add(tsk);
        tsk = new Task();
        tsk.setText("This is an message 2");
        tsk.setDate(OffsetDateTime.now().minusDays(2));
        list.add(tsk);
        return Collections.singletonMap("response", list);
    }

    */
}
