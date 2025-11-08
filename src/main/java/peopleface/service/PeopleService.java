package peopleface.service;

import peopleface.entity.People;

import java.util.List;

public interface PeopleService {
    List<People> conseguirPeople();
    People guardarPeople(People people);
    String eliminarTodos();
}
