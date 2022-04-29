package az.iktlab.groupj4web.service.impl;

import az.iktlab.groupj4web.service.HumanService;
import org.springframework.stereotype.Service;

@Service
public class HumanServiceImpl implements HumanService {

    @Override
    public void read(String word) {
        System.out.println(word);
    }
}
