package peopleface.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peopleface.entity.People;
import peopleface.repository.PeopleRepository;

import java.util.List;

@Service
public class PeopleServiceImp implements PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public List<People> conseguirPeople()
    {
        List<People> listaPeople = peopleRepository.findAll();
        return listaPeople;
    }

    @Override
    public People guardarPeople(People people)
    {
        return peopleRepository.save(people);
    }

}
