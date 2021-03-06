package com.we.weblog.mapper;

import com.we.weblog.domain.Log;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 *   日志管理的Mapper
 */
@Repository
@Mapper
public interface LogMapper  {

    @Insert({"insert into hexo_logs (action,data,author_id,ip,created) " +
            "values (#{l.action},#{l.data},#{l.author_id},#{l.ip},#{l.created})"})
    int addLog(@Param("l") Log log);


    @Select({"select id,action,ip,created from hexo_logs order by id desc limit #{l}"})
    List<Log> getLogs(@Param("l") int limit);


    @Delete({"delete from hexo_logs"})
    int removeAllLog();
}
