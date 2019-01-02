package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.DayName;
import pl.coderslab.repository.DayNameRepository;

import java.util.List;

@Service
@Transactional
public class DayNameService
{
    @Autowired
    private DayNameRepository dayNameRepository;

    public List<DayName> findAll()
    {
        return dayNameRepository.findAll();
    }
}
