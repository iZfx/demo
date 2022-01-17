package zhuojian.community.demo.mapper;

import org.apache.ibatis.annotations.*;
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

    @Select("select * from question limit #{offset}, #{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question where creator_id = #{userId} limit #{offset}, #{size}")
    List<Question> listByUserId(@Param(value = "userId") Integer userId, @Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from question where creator_id = #{userId}")
    Integer countByUserId(Integer userId);

    @Select("select * from question where id = #{id}")
    Question getById(long id);

    @Update("update question set title = #{title}, description = #{description}, gmt_modified = #{gmtModified}, tag = #{tag} where id = #{id}")
    void update(Question question);
}
