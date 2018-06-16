package com.hnu.scw.service.imp;

import com.hnu.scw.mapper.PersonMapper;
import com.hnu.scw.pojo.Person;
import com.hnu.scw.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：scw
 * @ Date       ：Created in 下午 1:56 2018/6/14 0014
 * @ Description：person实体操作的service实现类
 * @ Modified By：
 * @Version: $version$
 */
@Service
public class PersonServiceImp implements PersonService{
    @Autowired
    private PersonMapper personMapper;

    @Override
    public void personAdd(Person person) {
        personMapper.personAdd(person);
    }
}
