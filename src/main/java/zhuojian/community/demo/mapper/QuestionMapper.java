package zhuojian.community.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import zhuojian.community.demo.model.Question;

import java.util.List;

/**
 * Created by iZfx on 2022/1/11 21:41
 */
@Repository
@Mapper
public interface QuestionMapper {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator_id,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creatorId},#{tag})")
    void insert(Question question);

    @Select("select * from question")
    List<Question> list();
}