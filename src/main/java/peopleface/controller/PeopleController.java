package peopleface.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import peopleface.entity.People;
import peopleface.service.PeopleService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    @GetMapping
    public List<People> conseguirPeople() {
        return peopleService.conseguirPeople();
    }

    @PostMapping
    public People postPeople(@RequestBody People people)
    {
        return peopleService.guardarPeople(people);
    }
}
