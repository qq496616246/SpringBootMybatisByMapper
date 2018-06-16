package com.hnu.scw.mapper;

import com.hnu.scw.pojo.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ Author     ：scw
 * @ Date       ：Created in 下午 1:53 2018/6/14 0014
 * @ Description：用于处理person pojo相关的数据库操作
 * @ Modified By：
 * @Version: $version$
 */
//下面两个注解使用任一一个即可
//@Repository
@Mapper
public interface PersonMapper{
    /**
     * 添加一个人的数据信息
     * @param person
     */
     void personAdd(Person person);
}
